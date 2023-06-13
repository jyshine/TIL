# [Stateful and stateless widgets] (https://docs.flutter.dev/ui/interactive)
* A widget is either stateful or stateless. 
    * 위젯은 상태가 변는 것 또는 변경되지 않는 것이다.

* If a widget can change — when a user interacts with it, for example — it’s stateful.
    * 위젯이 변할 수 있다면 - 이것과 사용자가 상호작용할 때,예를 들어 - 이것은 stateful 이다.

* A stateless widget never changes. Icon, IconButton, and Text are examples of stateless widgets. 
    * A stateless widget은 절대 변하지 않는다. 아이콘, 아이콘 버튼, 그리고 텍스트들은 상태가 변하지 않는 위젯들이다.

* Stateless widgets subclass StatelessWidget.
    * Stateless 위젯들은 StatelessWidget 하위 클레스이다.

* A stateful widget is dynamic: for example, it can change its appearance in response to events triggered by user interactions or when it receives data.
    * 상태가 변하는 위젯은 동적이다: 예를 들어, 이것은 사용자의 상호작용하거나 받은 데이터로부터 이벤트들에 촉발되는 응답으로 보여지는 게 변할 수 있다. 

*  Checkbox, Radio, Slider, InkWell, Form, and TextField are examples of stateful widgets. Stateful widgets subclass StatefulWidget.
    * 체크박스, 레디오, 슬라이더, 잉크웰, 폼, 그리고 텍스트 필드 들은 stateful widgest들의 예시들이다. 상태가 변하는 위젯들은 StatefulWidget 의 하위 클레스이다.

* A widget’s state is stored in a State object, separating the widget’s state from its appearance. 
    * 위쳇들의 상태는 State 객체에 저장되고, 이를 통해 보여지는 위젯들의 상태와 보여지는게 분리된다.

* The state consists of values that can change, like a slider’s current value or whether a checkbox is checked. 
    * 상태가 고려된 값은 변할 수 있다, 슬라이더의 현재 값 또는 체크박스를 체크했는지 처럼

* When the widget’s state changes, the state object calls setState(), telling the framework to redraw the widget.
    * 위젯의 상태가 바뀔 때, 상태 객체는 setState()를 호출하여 프레임위크에 위젯을 다시 그리도록 알린다.

