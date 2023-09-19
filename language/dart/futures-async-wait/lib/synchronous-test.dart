import 'dart:io';

void perfromTasks() {
  task1();
  task2();
  task3();
}

void task3() {
  String result = 'task 3 data';
  print('Task 3 complete');
}

void task2() {
  Duration threeSeconds = new Duration(seconds: 3);

  sleep(threeSeconds);
  String result = 'task 2 data';
  print('Task 2 complete');
}

void task1() {
  String result = 'task 1 data';
  print('Task 1 complete');
}
