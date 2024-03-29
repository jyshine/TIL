package org.example.codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 평가 항목
 * * 동료로서 같이 일하기 좋은 코드를 작성하는가
 * * 컬렉션을 잘 다룰 수 있는가
 * * 논리를 단순화 할 수 있는가
 * * 부수효과(side-effects)를 갖지 않는 코드를 작성할 수 있는가
 *
 * 주의 사항
 * * 외부 도구를 사용해 문제를 푼 후 붙여넣으면 제한시간 치팅으로 간주합니다.
 * 처음부터 끝까지 코딩 테스트 편집기를 사용하고 주기적으로 코드를 실행해 결과를 확인해주세요.
 * 문제
 * list 목록과 count를 입력받아 count 만큼 요소들이 왼쪽 회전 이동된 목록을 반환하는 함수를 구현해주세요. 단, 입력된 목록은 변하지 않아야 합니다.
 * 조건
 * 문제와 동일하거나 유사한 플랫폼 제공 기능을 사용하지 않아야 합니다.
 * 입력된 목록은 변하지 않아야 합니다.
 * list의 크기보다 작은 0 과 같거나 큰 count를 입력받아 회전된 값을 반환합니다.
 * * 입력: list = [1, 2, 3, 4, 5], count = 2
 * * 출력: [3, 4, 5, 1, 2]
 * list의 크기보다 큰 count를 입력받아 회전된 값을 반환합니다.
 * * 입력: list = [1, 2, 3, 4, 5], count = 8
 * * 출력: [4, 5, 1, 2, 3]
 * 0 보다 작은 count를 입력받아 회전된 값을 반환합니다.
 * * 입력: list = [1, 2, 3, 4, 5], count = -1
 * * 출력: [5, 1, 2, 3, 4]
 */
class Solution{

    Integer[] getResult(Integer[] array, int count){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean isForward = true;
        Integer pointIndex = 0;
        int modVal =  count%array.length;

        for(int i=0; i<array.length;i++){
            hashMap.put(i, array[i]);
        }

        if(count == 0 || modVal==0){
            return array;
        }

        if(count<0){
            isForward = false;
        }

        pointIndex = modVal;

        if(!isForward) {
            pointIndex = array.length + modVal;
        }

        for(int i=0; i<array.length;i++){

            if(!hashMap.containsKey(pointIndex)){
                pointIndex = 0;
            }
            arrayList.add(hashMap.get(pointIndex));

            pointIndex++;
        }


        return arrayList.toArray(new Integer[0]);
    }
}

public class HealingPaper {
    public static void main(String[] args) {
        Integer[] list = {1, 2, 3, 4, 5, 6, 7};
        int count = -1;
        Solution solution = new Solution();
        Integer[] result = solution.getResult(list, count);
        System.out.println(Arrays.toString(result));

    }
}
