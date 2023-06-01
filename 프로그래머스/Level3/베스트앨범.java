package Level3;

import java.util.*;

public class º£½ºÆ®¾Ù¹ü {
	static class Album {
		int index, play;

		Album(int index, int play) {
			this.index = index;
			this.play = play;
		}
	}

	public int[] solution(String[] genres, int[] plays) {

		Map<String, Integer> genresMap = new HashMap<>();
		Map<String, List<Album>> indexMap = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
			if (!indexMap.containsKey(genres[i])) {
				indexMap.put(genres[i], new ArrayList<>());
			}
			indexMap.get(genres[i]).add(new Album(i, plays[i]));
		}
		int count = 0;
		for (Map.Entry<String, List<Album>> pair : indexMap.entrySet()) {
			List<Album> albumlist = pair.getValue();
			if (albumlist.size() >= 2)
				count += 2;
			else
				count++;
			Collections.sort(albumlist, (o1, o2) -> {
				if (o1.play == o2.play) {
					return o1.index - o2.index;
				}
				return o2.play - o1.play;
			});
		}
		int[] answer = new int[count];

		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(genresMap.entrySet());
		entryList.sort(((o1, o2) -> genresMap.get(o2.getKey()) - genresMap.get(o1.getKey())));

		int index = 0;
		for (int list = 0; list < entryList.size(); list++) {
			List<Album> albumList = indexMap.get(entryList.get(list).getKey());
			if (albumList.size() >= 2) {
				for (int i = 0; i < 2; i++) {
					answer[index++] = albumList.get(i).index;
				}
			} else {
				answer[index++] = albumList.get(0).index;
			}
		}

		return answer;

	}
}
