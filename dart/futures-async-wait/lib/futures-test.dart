import 'dart:io';

void perfromTasks() async {
  task1();
  String resultTask2 = await task2();
  task3(resultTask2);
}

void task3(String task2Result) {
  String result = 'task 3 data';
  print('Task 3 complete task2 Result $task2Result');
}

Future<String> task2() async {
  Duration threeSeconds = new Duration(seconds: 3);
  String result = '';
  // Future.delayed(Duration duration, [FutureOr<dynamic> Function()? computation])
  await Future.delayed(threeSeconds, () {
    result = 'task 2 data';
    print('Task 2 complete');
  });

  return result;
}

void task1() {
  String result = 'task 1 data';
  print('Task 1 complete');
}


  /// Creates a future that runs its computation after a delay.
  ///
  /// The [computation] will be executed after the given [duration] has passed,
  /// and the future is completed with the result of the computation.
  ///
  /// If [computation] returns a future,
  /// the future returned by this constructor will complete with the value or
  /// error of that future.
  ///
  /// If the duration is 0 or less,
  /// it completes no sooner than in the next event-loop iteration,
  /// after all microtasks have run.
  ///
  /// If [computation] is omitted,
  /// it will be treated as if [computation] was `() => null`,
  /// and the future will eventually complete with the `null` value.
  /// In that case, [T] must be nullable.
  ///
  /// If calling [computation] throws, the created future will complete with the
  /// error.
  ///
  /// See also [Completer] for a way to create and complete a future at a
  /// later time that isn't necessarily after a known fixed duration.
  ///
  /// Example:
  /// ```dart
  /// Future.delayed(const Duration(seconds: 1), () {
  ///   print('One second has passed.'); // Prints after 1 second.
  /// });
  /// ```