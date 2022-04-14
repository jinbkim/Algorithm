## Brute Force
- 모든 경우의 수를 확인하여 답을 찾는 방법
### Back Tracking
- 모든 경우의 수를 탐색하는 과정에서 해가 될 가능성이 없으면 탐색을 중지 시킨 뒤 그 이전으로 돌아가서 다른 경우를 탐색

#
## Greedy
- 결정의 순간마다 최적이라고 생각되는것을 선택해 답을 찾는 방법
- 이전의 선택이 이후의 선택에 영향을 주지 않아야 함

#
## Divide And Conquer
- 문제를 나눌 수 없을 때 까지 나누고, 각각을 풀면서 다시 합병하여 문제의 답을 찾는 방법
- 문제를 둘 이상의 부분 문제로 나누는 자연스러운 방법이 존재해야 함
- 부분문제의 답을 이용하여 원래의 답을 계산하는 효율적인 방법이 존재해야 함

#
## Binary Search
- 정렬되어 있는 리스트에서 탐색 범위를 절반씩 좁혀가며 데이터를 탐색
- 숫자가 크면 int 대신 long을 사용하자

#
## Shortest Path
### Dijkstra
- 특정한 하나의 정점에서 다른 모든 정점으로 가는 최단경로를 찾는 방법
- 간선들의 가중치는 모두 양수 이어야 함
### Bellman Ford
- 특정한 하나의 정점에서 다른 모든 정점으로 가는 최단경로를 찾는 방법
- 간선의 가중치가 음수일때도 사용 가능
- 최단거리 변수가 굉장히 작아질수도 있으니 long을 사용하자
- 방문 가능한지 확인하려면, 
    * visit 배열을 만들고 도착지점 부터 체크 하기
- 음의 순환구조가 있는지만 확인하려면,
    * 출발점과 확인하려는 간선의 출발지점까지 경로가 없어도 탐색해야 함
### Floyd Warshall
- 모든 정점에서 모든 정점으로의 최단경로를 찾는 방법
- 간선의 가중치가 음수일때도 사용 가능
- 최단거리 변수가 굉장히 작아질수도 있으니 long을 사용하자