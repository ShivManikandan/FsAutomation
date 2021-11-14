package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import threadlocalbaseclass.BaseClass;


@CucumberOptions(features="src\\test\\java\\features\\CreateWorkType.feature",
glue={"threadlocalpages"},monochrome=true,dryRun=false,snippets=SnippetType.CAMELCASE)

public class Runtest extends BaseClass{
@Override

	   @DataProvider(parallel=true)
	    public Object[][] scenarios() {
	      
	        return super.scenarios();
	    }
}
