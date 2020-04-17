package PT2019.PT2019.Assignment5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public List<MonitoredData> readFromFile() throws IOException {
		String fileName = "d://PT2019//pt2019_30226_urcan_denisa_assignment_5//Activities.txt";
		File file = new File(fileName);
		List<MonitoredData> monitoredDataList = new ArrayList<MonitoredData>();
		try (Stream<String> streamLine = Files.lines(file.toPath())) {
			streamLine.forEach(line -> {
				// System.out.println(line);
				// List<String> splitLine = Arrays.asList(line.split(" "));
				// System.out.println("After split " + splitLine);
				List<String> splitLine = Stream.of(line.split("		")).map(elem -> new String(elem))
						.collect(Collectors.toList());
				// System.out.println("Start time" + splitLine.get(0).split(" ")[0]);
				monitoredDataList.add(new MonitoredData(splitLine.get(0), splitLine.get(1), splitLine.get(2)));

			});
		}
		return monitoredDataList;
	}

	public long countDays(List<MonitoredData> monitoredDataList) {
		long count = 0;
		List<String> days = monitoredDataList.stream().map(x -> Stream.of(x.getStartTime().split(" "))
				.map(elem -> new String(elem)).collect(Collectors.toList()).get(0)).collect(Collectors.toList());
		// sau puteam face direct monitoredDataList.stream().map(x ->
		// x.getStrartTime().split(" ")[0]).collect(Collectors.toList());
		count = days.stream().distinct().count();
		return count;
	}

	public Map<String, Integer> mapOfActivities(List<MonitoredData> monitoredDataList) {

		Map<String, Long> mapActivities = null;
		mapActivities = monitoredDataList.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.counting()));
		Map<String, Integer> map = new HashMap<String, Integer>();
		mapActivities.forEach((k, v) -> map.put(k.trim(), Integer.parseInt(v + "")));
		return map;
	}

	public Map<String, Map<String, Long>> mapOfActivitiesForEachDay(List<MonitoredData> monitoredDataList) {
		Map<String, Map<String, Long>> map = null;
		map = monitoredDataList.stream().collect(Collectors.groupingBy((x -> x.getStartTime().split(" ")[0].trim()),
				Collectors.groupingBy((x -> x.getActivity().trim()), Collectors.counting())));
		return map;
	}

	@SuppressWarnings("deprecation")
	public List<String> endTimeMinusStartTime(List<MonitoredData> monitoredDataList) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Long> dateRecord = monitoredDataList.stream().map(x -> {
			try {
				return ((simpleDateFormat.parse(x.getEndTime())).getTime()
						- (simpleDateFormat.parse(x.getStartTime())).getTime());
			} catch (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
				return null;
			}
		}).map(elem -> new Long(elem)).collect(Collectors.toList());

		return dateRecord.stream()
				.map(e -> Stream.of(" " + e / 1000 / 3600 + ":" + e / 1000 / 60 % 60 + ":" + e / 1000 % 60)
						.map(elem -> new String(elem)).collect(Collectors.toList()).get(0))
				.collect(Collectors.toList());
	}

	public  void durationOverEachActivity(List<MonitoredData> monitoredDataList) {

		List<String> activities = monitoredDataList.stream().map(elem -> elem.getActivity().toString())
				.collect(Collectors.toList());
		List<String> act = endTimeMinusStartTime(monitoredDataList);
		// System.out.println(activities);
		// System.out.println(act);

		IntStream.range(0, activities.size()).mapToObj(index -> act.get(index) + " " + activities.get(index))
				.collect(Collectors.toList()).forEach(System.out::println);

		// System.out.println(res);

	}

	public Map<String, String> totalDurationForEachActivity(List<MonitoredData> monitoredDataList) {
		Map<String, String> totalDuration = null;
		List<String> activities = monitoredDataList.stream().map(x -> x.getActivity()).distinct()
				.collect(Collectors.toList());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (String activity : activities) {
			Long durationPerActivity = monitoredDataList.stream()
					.filter(x -> x.getActivity().toString().equals(activity)).mapToLong(x -> {
						try {
							return ((simpleDateFormat.parse(x.getEndTime())).getTime()
									- (simpleDateFormat.parse(x.getStartTime())).getTime());
						} catch (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
							return (Long) null;
						}
					}).sum();
			String duration = durationPerActivity / 1000 / 3600 + ":" + durationPerActivity / 1000 / 60 % 60 + ":"
					+ durationPerActivity / 1000 % 60;
			System.out.println(activity.trim() + ": " + duration);
			// totalDuration.put(activity, durationPerActivity);
		}
		return totalDuration;
	}

	public void showIntMap(Map<String, Integer> mapActivitiesForEachDay) {
		for (Entry<String, Integer> entry : mapActivitiesForEachDay.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue() + "\n");
	}

	public void showMap(Map<String, Map<String, Long>> mapActivitiesForEachDay) {
		for (Entry<String, Map<String, Long>> entry : mapActivitiesForEachDay.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue() + "\n");
	}

	public void activities90Percent(List<MonitoredData>monitoredDataList) {
		List<String> activities = monitoredDataList.stream().map(x -> x.getActivity()).distinct()
				.collect(Collectors.toList());
		List<String> res = new ArrayList<String>();
		Long result;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long up, down;
		for(String activity : activities) {
			up = monitoredDataList.stream().filter(x -> x.getActivity().compareTo(activity) == 0).filter(y -> {
				try {
					return (simpleDateFormat.parse(y.getEndTime()).getTime() - simpleDateFormat.parse(y.getStartTime()).getTime()) < 300000;
				} catch (ParseException e) {
					e.printStackTrace();
					return false;
				}
			}).count();
			down = monitoredDataList.stream().filter(x -> x.getActivity().compareTo(activity) == 0).count();
			
			result = up/ down * 100;
			
			if(result >= 90 ) {
				res.add(activity);
			}
		}
		for(String s: res) {
			System.out.println(s);
		}
	}
}
