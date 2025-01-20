package Test;

import org.testng.ITestListener;

public class demoListeners implements ITestListener {

//have to implement on failure or on success case
	// so on success or failure of each cases the code written within respective
	// blocks will be executed
	// lets say if we want to capture logs or screenshot of gui when some fail
	// happens, then we can write screenshot code in failure
	// class and then it will capture screenshot on every fail of testcase

	// We have to give class path in xml file then only our xml file will know where
	// is listener file located a
	// once it get that file then only its failure success etc codes will be
	// executed
}
