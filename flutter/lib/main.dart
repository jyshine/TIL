import 'package:flutter/material.dart';

class MyCustomPainter extends CustomPainter {
  @override
  void paint(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = Colors.blue
      ..style = PaintingStyle.fill;

    canvas.drawRect(
        Rect.fromLTRB(50, 40, size.width - 40, size.height - 100), paint);
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return false;
  }
}

class CustomPaintExample extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('CustomPaint Example'),
      ),
      body: Center(
        child: CustomPaint(
          painter: MyCustomPainter(),
          size: Size(200, 400),
        ),
      ),
    );
  }
}

void main() {
  runApp(MaterialApp(
    home: CustomPaintExample(),
  ));
}
