import json

import requests
from flask import Flask, request
from py_zipkin.encoding import Encoding
from py_zipkin.zipkin import zipkin_span, ZipkinAttrs
from py_zipkin.transport import BaseTransportHandler

from mongo_api import MongoAPI

app = Flask(__name__)


class HttpTransport(BaseTransportHandler):
    print("HttpTransport")

    def get_max_payload_bytes(self):
        return None

    def send(self, encoded_span):
        # The collector expects a thrift-encoded list of spans.
        requests.post(
            'http://localhost:9411/api/v1/spans',
            data=encoded_span,
            headers={'Content-Type': 'application/x-thrift'},
        )


def default_handler(encoded_span):
    print(f"encoded_span {encoded_span}")
    body = encoded_span
    app.logger.debug("body %s", body)
    return requests.post(
        "http://127.0.0.1:9411/api/v2/spans",
        data=body,
        headers={'Content-Type': 'application/json'},
    )


@app.before_request
def log_request_info():
    app.logger.debug('Headers: %s', request.headers)
    app.logger.debug('Body: %s', request.get_data())


@app.route('/test')
def flask_home():
    with zipkin_span(
            service_name='flask-service',
            zipkin_attrs=ZipkinAttrs(
                trace_id=request.headers['X-B3-TraceID'],
                span_id=request.headers['X-B3-SpanID'],
                parent_span_id=request.headers['X-B3-ParentSpanID'],
                flags=1,
                is_sampled=request.headers['X-B3-Sampled'],
            ),
            span_name=request.path,
            transport_handler=default_handler,
            sample_rate=100,
            encoding=Encoding.V2_JSON
    ):
        print("OK")
    return 'OK', 200


@app.route('/findAllCustomer', methods=['GET'])
def find_all():
    with zipkin_span(
            service_name='flask-service',
            zipkin_attrs=ZipkinAttrs(
                trace_id=request.headers['X-B3-TraceID'],
                span_id=request.headers['X-B3-SpanID'],
                parent_span_id=request.headers['X-B3-ParentSpanID'],
                flags=1,
                is_sampled=request.headers['X-B3-Sampled'],
            ),
            span_name=request.path,
            transport_handler=default_handler,
            sample_rate=100,
            encoding=Encoding.V2_JSON
    ):
        data = {
            'database': 'test',
            'collection': 'customer'
        }
        read = MongoAPI(data).read()
    return json.dumps(read), 200


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', threaded=True, port=5001)
