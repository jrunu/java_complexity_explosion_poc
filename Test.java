import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		String message = getFirstLine("message.txt");
		String pattern = getFirstLine("pattern.txt");
		regex_run(pattern, message);
	}


	public static String getFirstLine(String path) {
		try {
			List<String> allLines = Files.readAllLines(Paths.get(path));
			return allLines.get(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void regex_run(String pattern, String message) throws Exception {
		Pattern p = Pattern.compile(pattern);

		Long start = System.currentTimeMillis();
		Matcher m = p.matcher(message);
		boolean matches = m.find();
		Long timeElapsed = System.currentTimeMillis() - start;
		
		String result = String.format("Took %dms, %s", timeElapsed, matches ? "matching" : "non matching");
		System.out.println(result);
	}

}

