package PT2019.PT2019.Assignment5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {

	

	public static void main(String[] args) {

		List<MonitoredData> monitoredDataList = null;
		Main main = new Main();
		long count = 0;
		try {
			monitoredDataList = main.readFromFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(
				"-----------------------------1. List of MonitoredData -------------------------------------------------");
		System.out.println(monitoredDataList);
		count = main.countDays(monitoredDataList);
		System.out.println(
				"-----------------------------2. Count how many days are in the log. ------------------------------");
		System.out.println(count);
		System.out.println(
				"-----------------------------3. How many times has appeared each activity. --------------------------------");
		Map<String, Integer> mapActivities = main.mapOfActivities(monitoredDataList);
		// System.out.println(mapActivities);
		main.showIntMap(mapActivities);
		System.out.println(
				"-----------------------------4. How many times has appeared each activity for each day. ---------------------------");
		Map<String, Map<String, Long>> mapActivitiesForEachDay = main.mapOfActivitiesForEachDay(monitoredDataList);
		main.showMap(mapActivitiesForEachDay);
		System.out.println(
				"-----------------------------5. The entire duration for each activity. -----------------------------");
		main.durationOverEachActivity(monitoredDataList);

		// Map<String, Long> totalDurationForEachAct =
		System.out.println(
				"-----------------------------6. The entire duration. ---------------------------------------------");
		main.totalDurationForEachActivity(monitoredDataList);
		// System.out.println(totalDurationForEachAct);
		System.out.println(
				"-----------------------------7. Activities that have 90% duration less than 5 minutes. -------------------------");
		main.activities90Percent(monitoredDataList);
	}
}
