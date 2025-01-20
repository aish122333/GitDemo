package Aishwarya.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class DataReader {

	public List<HashMap<String,String>> readJson() throws IOException {
		//Convert json file to string
		String jsonfile = FileUtils.readFileToString(new File("/home/pelatro/aish/selenium/SeleniumIntroduction/src/test/java/Aishwarya/data"), StandardCharsets.UTF_8);
		//Convert string file to hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonfile,
				new TypeReference<List<HashMap<String, String>>>() {});
		return data;
	}

}

