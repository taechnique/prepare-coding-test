package dp.bj;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TestHash {

    /**
     * <b>문제</b>
     * <hr>
     * <p>수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.</p>
     *
     * <p>마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.</p>
     *
     * <h5>제한사항</h5>
     *
     * <ul>
     * <li>마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.</li>
     * <li>completion의 길이는 participant의 길이보다 1 작습니다.</li>
     * <li>참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.</li>
     * <li>참가자 중에는 동명이인이 있을 수 있습니다.</li>
     * </ul>
     *
     * <h5>입출력 예</h5>
     * <table class="table">
     *         <thead><tr>
     * <th>participant</th>
     * <th>completion</th>
     * <th>return</th>
     * </tr>
     * </thead>
     *         <tbody><tr>
     * <td>["leo", "kiki", "eden"]</td>
     * <td>["eden", "kiki"]</td>
     * <td>"leo"</td>
     * </tr>
     * <tr>
     * <td>["marina", "josipa", "nikola", "vinko", "filipa"]</td>
     * <td>["josipa", "filipa", "marina", "nikola"]</td>
     * <td>"vinko"</td>
     * </tr>
     * <tr>
     * <td>["mislav", "stanko", "mislav", "ana"]</td>
     * <td>["stanko", "ana", "mislav"]</td>
     * <td>"mislav"</td>
     * </tr>
     * </tbody>
     *       </table>
     * <h5>입출력 예 설명</h5>
     *
     * <p>예제 #1<br>
     * "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.</p>
     *
     * <p>예제 #2<br>
     * "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.</p>
     *
     * <p>예제 #3<br>
     * "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.</p>
     *
     * <p><a href="https://programmers.co.kr/learn/courses/30/lessons/42576" target="_blank" rel="noopener">완주하지 못한 선수</a></p>
     * @throws Exception
     */
    public static void nonFinishedPlayer() throws Exception {
        String [] participant= {"marina", "josipa", "nikola", "nikola", "vinko", "filipa"};
        String [] completion = {"josipa", "filipa", "marina", "nikola", "nikola"};

        Map<String, Long> map = Arrays.stream(participant)
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        for(String name : completion) {

            Long count = map.get(name) - 1L;

            if(count == 0L) {
                map.remove(name);
            } else {
                map.put(name, count);
            }
        }

        String player = map.keySet().iterator().next();

        System.out.println("player = " + player);
    }

    /**
     * <b>문제</b>
     * <hr>
     * <div class="guide-section-description">
     *       <h6 class="guide-section-title">문제 설명</h6>
     *       <div class="markdown solarized-dark"><p>전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.<br>
     * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.</p>
     *
     * <ul>
     * <li>구조대 : 119</li>
     * <li>박준영 : 97 674 223</li>
     * <li>지영석 : 11 9552 4421</li>
     * </ul>
     *
     * <p>전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.</p>
     *
     * <h5>제한 사항</h5>
     *
     * <ul>
     * <li>phone_book의 길이는 1 이상 1,000,000 이하입니다.
     *
     * <ul>
     * <li>각 전화번호의 길이는 1 이상 20 이하입니다.</li>
     * <li>같은 전화번호가 중복해서 들어있지 않습니다.</li>
     * </ul></li>
     * </ul>
     *
     * <h5>입출력 예제</h5>
     * <table class="table">
     *         <thead><tr>
     * <th>phone_book</th>
     * <th>return</th>
     * </tr>
     * </thead>
     *         <tbody><tr>
     * <td>["119", "97674223", "1195524421"]</td>
     * <td>false</td>
     * </tr>
     * <tr>
     * <td>["123","456","789"]</td>
     * <td>true</td>
     * </tr>
     * <tr>
     * <td>["12","123","1235","567","88"]</td>
     * <td>false</td>
     * </tr>
     * </tbody>
     *       </table>
     * <h5>입출력 예 설명</h5>
     *
     * <p>입출력 예 #1<br>
     * 앞에서 설명한 예와 같습니다.</p>
     *
     * <p>입출력 예 #2<br>
     * 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.</p>
     *
     * <p>입출력 예 #3<br>
     * 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.</p>
     *
     * <hr>
     *
     * <p><strong>알림</strong></p>
     *
     * <p>2021년 3월 4일, 테스트 케이스가 변경되었습니다. 이로 인해 이전에 통과하던 코드가 더 이상 통과하지 않을 수 있습니다.</p>
     *
     * <p><a href="https://programmers.co.kr/learn/courses/30/lessons/42577" target="_blank" rel="noopener">전화번호 목록</a></p>
     *
     * @throws Exception
     */
    public static void phoneNumberList() throws Exception {
        String [] phone_book = {"12","123","1235","567","88"};

        boolean answer = true;
        Set<String> set = new HashSet();

        for(int i = 0;i < phone_book.length;i++) {
            set.add(phone_book[i]);
        }

        for(int i = 0;i < phone_book.length;i++) {
            int length = phone_book[i].length();
            for(int j = 1;j < length;j++) {
                if(set.contains(phone_book[i].substring(0, j))) {
                    answer = false;
                    break;
                }
            }
            if(!answer) {
                break;
            }
        }
    }

    /**
     * <b>문제</b>
     * <hr>
     * <p>스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.</p>
     *
     * <p>예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.</p>
     * <table class="table">
     *         <thead><tr>
     * <th>종류</th>
     * <th>이름</th>
     * </tr>
     * </thead>
     *         <tbody><tr>
     * <td>얼굴</td>
     * <td>동그란 안경, 검정 선글라스</td>
     * </tr>
     * <tr>
     * <td>상의</td>
     * <td>파란색 티셔츠</td>
     * </tr>
     * <tr>
     * <td>하의</td>
     * <td>청바지</td>
     * </tr>
     * <tr>
     * <td>겉옷</td>
     * <td>긴 코트</td>
     * </tr>
     * </tbody>
     *       </table>
     * <p>스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.</p>
     *
     * <h5>제한사항</h5>
     *
     * <ul>
     * <li>clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.</li>
     * <li>스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.</li>
     * <li>같은 이름을 가진 의상은 존재하지 않습니다.</li>
     * <li>clothes의 모든 원소는 문자열로 이루어져 있습니다.</li>
     * <li>모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.</li>
     * <li>스파이는 하루에 최소 한 개의 의상은 입습니다.</li>
     * </ul>
     *
     * <h5>입출력 예</h5>
     * <table class="table">
     *         <thead><tr>
     * <th>clothes</th>
     * <th>return</th>
     * </tr>
     * </thead>
     *         <tbody><tr>
     * <td>[["yellow<u>hat", "headgear"], ["blue</u>sunglasses", "eyewear"], ["green_turban", "headgear"]]</td>
     * <td>5</td>
     * </tr>
     * <tr>
     * <td>[["crow<u>mask", "face"], ["blue</u>sunglasses", "face"], ["smoky_makeup", "face"]]</td>
     * <td>3</td>
     * </tr>
     * </tbody>
     *       </table>
     * <h5>입출력 예 설명</h5>
     *
     * <p>예제 #1<br>
     * headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.</p>
     * <ol>
     *     <li>yellow_hat</li>
     *     <li>blue_sunglasses</li>
     *     <li>green_turban</li>
     *     <li>yellow_hat + blue_sunglasses</li>
     *     <li>green_turban + blue_sunglasses</li>
     * </ol>
     * <p>예제 #2<br>
     * face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.</p>
     * <ol>
     *     <li>crow_mask</li>
     *     <li>blue_sunglasses</li>
     *     <li>smoky_makeup</li>
     * </ol>
     * <p><a href="https://programmers.co.kr/learn/courses/30/lessons/42578" target="_blank" rel="noopener">위장</a></p>
     * @throws Exception
     */
    public static void camouflage() throws Exception {
        int answer = 0;
        String [][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        answer = Arrays.stream(clothes).collect(groupingBy(arr -> arr[1], counting()))
                .values().stream().collect(reducing(1L, (before, now) -> before * (now + 1L))).intValue() - 1;

        System.out.println("answer = " + answer);
    }
}
