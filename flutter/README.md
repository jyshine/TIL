# [Stateful and stateless widgets] (https://docs.flutter.dev/ui/interactive)
* A widget is either stateful or stateless. 
* If a widget can change—when a user interacts with it, for example—it’s stateful.

* A stateless widget never changes. Icon, IconButton, and Text are examples of stateless widgets. 
* Stateless widgets subclass StatelessWidget.

* A stateful widget is dynamic: for example, it can change its appearance in response to events triggered by user interactions or when it receives data.
*  Checkbox, Radio, Slider, InkWell, Form, and TextField are examples of stateful widgets. Stateful widgets subclass StatefulWidget.

* A widget’s state is stored in a State object, separating the widget’s state from its appearance. 
* The state consists of values that can change, like a slider’s current value or whether a checkbox is checked. 
* When the widget’s state changes, the state object calls setState(), telling the framework to redraw the widget.

