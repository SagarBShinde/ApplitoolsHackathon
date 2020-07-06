# Applitools UFG Hackathon 2020
## Table of contents

* [Introduction](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#introduction)
* [System Requirements](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#system-requirements)
* [Test Results](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#test-results) 
* [Instructions To Run Tests](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#instructions-to-run-tests)
* [Traditional UI Testing Approach](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#traditional-ui-testing-approach)
   * [UI Test Framework](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#ui-test-framework)
   * [Framework Concepts](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#framework-concepts)
   * [Page Object Model Using Components](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#page-object-model-using-components)
   * [Test Design](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#test-design)
   * [Sample UI Test](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#sample-ui-test)
   * [Reporting](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#reporting)
   * [Getting Started](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#getting-started)





## Introduction
This project is a collection of four maven subprojects that are created for [Applitools UFG Hackathon 2020](https://applitools.com/cross-browser-testing-hackathon-v20-1-apply/). As per hackathon instructions the 2 versions of the applitools demo app have been automated by the modern and traditional approach.
Frameworks : Java + Selenium 3 + TestNG

## System Requirements
The code has been tested with following configurarion
  * MacBook Pro - macOS Mojave  v10.14.5
  * Java v 1.8.0_221
  * Selenium 3.141.0
  * Apache Maven 3.6.2
  * Browsers
    * Google Chrome Version 83.0.4103.116 (Official Build) (64-bit)
    * Microsoft Edge Chromium - Version 83.0.478.58 (Official build) (64-bit)
    * Mozilla Firefox Version 78.0.1 (64-bit)

## Test Results

### Modern V1
* **Total TCs:** 3
* **Pass TCs:** 3 
* **Failed TCs:** 0
* **UFG Batch Status:** Unresolved
* [Test Results](https://eyes.applitools.com/app/test-results/00000251808239140134/?accountId=mdeyMVGPpkmhCDsGnZPwXw~~)

### Modern v2
* **Total TCs:** 3
* **Pass TCs:** 0
* **Failed TCs:** 3
* **UFG Batch Status:** Failed 
* [Test Results](https://eyes.applitools.com/app/test-results/00000251808238892279/?accountId=mdeyMVGPpkmhCDsGnZPwXw~~)

### Traditional V1
* **Total TCs:** 371
* **Pass TCs:** 371
* **Failed TCs:** 0

### Traditional V2
* **Total TCs:** 371
* **Pass TCs:** 281
* **Failed TCs:** 90

**Notes** : 
1. No. Of Failures are high for Traditional V2 run since the traditional framework checks visibility as well as other visual attributes e.g. element size, location, text, color. All the failure reasons can be found in Traditional-V2-TestResults-with-Failure-Reasons.txt in the root folder. Please refer [Traditional UI Testing Approach](https://github.com/SagarBShinde/ApplitoolsHackathon/blob/master/README.md#traditional-ui-testing-approach) for further details
2. Traditional Tests have been tested on MAC and may fail if run on Windows/ Linux Machine since the Visual Attributes (Refer framework concepts section) are specific to browsers installed on MAC machine



## Instructions to run tests
1. Clone the repo from this [location](https://github.com/SagarBShinde/ApplitoolsHackathon) on GitHub
2. Open a terminal and navigate to the parent repository 
   ```shell
   cd <Path to ApplitoolsHackathon project>
   ```
3. The repo should contain 4 sub-projects as follows
    1. TraditionalTestsV1
    2. TraditionalTestsV2
    3. ModernTestsV1
    4. ModernTestsV2
4. Running tests against version 1 of the website using the Modern approach
    1. Navigate to repo ModernTestsV1
        ```shell
         cd <Path to ApplitoolsHackathon project>/ModernTestsV1
         ```
   2. Run the following command to start test execution
        ```shell
        mvn clean test -DsuiteXMLFile=ApplitoolsModernV1Suite.xml
        ```
   3. Once the test execution is complete, Test results can be checked at the following location
        [Applitools Eyes Test Results](https://eyes.applitools.com/app/test-results/00000251808385651918/?accountId=mdeyMVGPpkmhCDsGnZPwXw~~)
        Batch Name: UFG Hackathon
        Note: Hit refresh and check the correct batch after verifying date and time of run.
    4. The status of tests and the Batch will be 'Unresolved' since the Baseline contains all the Bug regions and V1 version of the demo website is bug-free. This leads to the difference between Baseline and the latest checkpoints that results in 'unresolved' status
    5. Locally, TestNG Tests will fail with exception: 
        java.lang.Error:com.applitools.eyes.exceptions.DiffsFoundException 
    6. Logs of execution can be found at <Path to ApplitoolsHackathon project>/ModernTestsV1/logs/app.log

5. Running tests against version 2 of the website using Modern approach
    1. Navigate to repo ModernTestsV2
        ```shell
         cd <Path to ApplitoolsHackathon project>/ModernTestsV2
         ```
   2. Run following command to start test execution
        ```shell
        mvn clean test -DsuiteXMLFile=ApplitoolsModernV2Suite.xml
        ```
   3. Once the test execution is complete, Test results can be checked at the following location
        [Applitools Eyes Test Results](https://eyes.applitools.com/app/test-results/00000251808385651918/?accountId=mdeyMVGPpkmhCDsGnZPwXw~~)
        Batch Name: UFG Hackathon
        Note: Hit refresh and check the correct batch after verifying date and time of run
    4. The status of tests and the Batch will be 'Failed' since the Baseline contains all the Bug regions and all the bugs are reproduced. Applitools automatically detects the bug regions in the new checkpoint snapshots and fails the tests
    5. Locally, TestNG tests fill fail with exception : 
    java.lang.Error: com.applitools.eyes.exceptions.TestFailedException: 
    6. Logs of execution can be found at <Path to ApplitoolsHackathon project>/ModernTestsV2/logs/app.log

6. Running tests against v1 of the website using Traditional Approach
    1. Navigate to repo TraditionalTestsV1
        ```shell
         cd <Path to ApplitoolsHackathon project>/TraditionalTestsV1
         ```
   2. Run the following command to start test execution
        ```shell
        mvn clean test -DsuiteXMLFile=ApplitoolsTraditionalV1Suite.xml
        ```
    3.  Once the test execution is complete, TestNG report will be generated showing status of each test. All tests should pass since the version 1 of the app is bug free.
    4. The validation report will get generated at the following location
        <Path to ApplitoolsHackathon project>/TraditionalTestsV1/Output/report_<timestamp>.txt
        Note: Each run will generate the report with the file name - "report_<timestamp of execution>.txt". 
        check the report with the correct timestamp
    5. Logs of execution can be found at <Path to ApplitoolsHackathon project>/TraditionalTestsV1/logs/app.log
7. Running tests against v1 of the website using Traditional Approach
    1. Navigate to repo TraditionalTestsV2
        ```shell
         cd <Path to ApplitoolsHackathon project>/TraditionalTestsV2
         ```
   2. Run the following command to start test execution
        ```shell
        mvn clean test -DsuiteXMLFile=ApplitoolsTraditionalV2Suite.xml
        ```
    3.  Once the test execution is complete, TestNG report will be generated showing the status of each test. There will be test failures since V2 version of the app has bugs
    4. The validation report will get generated at the following location
        <Path to ApplitoolsHackathon project>/TraditionalTestsV2/Output/report_<timestamp>.txt
        Note: Each run will generate the report with the file name - "report_<timestamp of execution>.txt". 
        check the report with the correct timestamp
    5. Logs of execution can be found at <Path to ApplitoolsHackathon project>/TraditionalTestsV2/logs/app.log
    
## Traditional UI Testing Approach
### UI Test Framework
A simple framework is created for UI Validations. The user records the key elements in the component on the given page in a JSON file. The user then creates test cases to validate the UI Elements. The framework compares the actual visual attributes of the elements on the page against the ones recorded in the JSON file. The differences are recorded in the custom text file report.

### Framework Concepts
* **Test Target:**
    Test Target is a unique combination of Device, Browser, Browser size and Device orientation that defines the target for running Tests. The Test Targets are stored in config directory in JSON format.
    ```json
            {
            "targetName" : "laptop_chrome",
            "visual_attribute_dir" : ".//config/visual_attributes//laptop//chrome_and_edge_chromium",
            "device" : {
                "deviceName" : "MacBookPro",
                "deviceType" : "LAPTOP",
                "platform" : "MAC",
                "os" : "macOS Mojave",
                "os_version" : "10.14.5 (18F132)"
            },
            "orientation" : "POTRAIT",
            "browser" : {
                "browserName" : "Chrome",
                "version" : "v83.0.4103.116 (Official Build) (64-bit)"
            },
            "browserSize" : {
                "height" : 700,
                "width" : 1200
            }
        }
    ```
* **Test Target List Annotation:**
    TestTargetList is a custom annotation that is provided on each test class. This annotation defines the array of Test targets against which the test methods in the given class are to be run. 
    Test Target is one of the instance variable on the Test class. Factory method in the BaseTest class reads the annotation and initializes TestTarget variable for each Test run of the given Test class
    In the following example, The test_target.json in the config directory will be searched for JSONArray named "Laptop_all". This array contains 3 Test targets [MacBook with Chrome, MacBook with Firefox and MacBook with Edge]. In the runtime, 3 instances of the Test class will be created for each Test target and the Test class will be executed
    Multiple groups of Test Targets can be specified in the annotation value as a comma-separated list.
   **Note:** For the current version of the framework the device in the Test Target is ignored since all the Tests are run in a LAPTOP against different browser sizes (view ports).

    ```java
    @Test
    @TestTargetList({"Laptop_all"})
    public class CrossDeviceElementTest_1 extends AppliToolsBaseTest {
    }
    ```
* **Visual Attributes:**
Visual Attributes refer to the visual properties of a Web Element on the Page. The element's appearance on the web page are determined by some key element properties that are- Element visibility, Text, Element size, Element location, and css properties like color, background color, text decoration, etc.
The framework divides the element visual attributes into two categories- Primary and secondary.
Primary properties: Visibility, Size, Location and visible text
This how visual attributes are stored in a JSON File (This is a Baseline for UI Elements)
```json
            {
                "element_name" : "originalPrice",
                "isDisplayed" : true,
                "element_text" : "$48.00",
                "element_size" : {
                    "height" : 24,
                    "width" : 50
                },
                "element_location" : {
                    "X" : 826,
                    "Y" : 771
                },
               "css_properties":{
                    "color": "rgba(153, 153, 153, 1)",
                    "text-decoration-line": "line-through"
               }
```
Secondary Properties: Any computed CSS property of the Element e.g. Color
The visual attributes are stored in the config directory under the corresponding Test Target.
Each Test Target will have it's own visual attributes directory with JSON files corresponding to pages in the application
In the Config directory the JSON visual attributes for Home page are stored at following location for Target:
Laptop- firefox- Viewport 1200 X 700
<Path To AppliToons Hackathon Project>/TraditionalTestsV2/config/visual_attributes/laptop/firefox/HomePage.json

### Page Object Model using Components
Customized Page Object Model has been used for the Test Design. The modern web applications use reusable components. The pages in the Framework have also been designed using the same technique. Each Page is built from reusable components. 
For ex: HomePage consists of AppHeader, NavigationBar, Filters, ProductSection.
Component provide an interface to interact with the web elements that are present in the compoenent 
Page provides an API that executes Business Functionality
For Ex: Fitering and selecting a product is a Business functionality that has been coded in the HomePage as follows
```java
    public void applyColorFilter(String color) throws FrameworkException {
        this.productSection.openFilter();
        this.colorFilter.selectFilterOption(color);
        this.filterButtons.applyFilter();
    }
    
    public ProductDetailPage selectProductFromProductGrid(int productIndex) {
        this.productSection.viewProductDetail(productIndex -1);
        ProductDetailPage productDetailsPage = new ProductDetailPage(this.driver);
        productDetailsPage.wait_til_load();
        return productDetailsPage;
    }
```
**Note**: Since the Demo application under test contain well defined unique IDs and there are no dynamic locators , components have been designed using Page factory. Be informed that using Page Factory can pose problems if the applications have a lot for dynamic locators. There are other shortcomings of the Pagefactory as well. Please make an informed decision while opting for PageFactory.

### Test Design
The UI Test case design is simple since a majority of complex functionality has been abstracted in BaseTest class in the framework
For validating UI, each element on the component will have a dedicated method for validating its visual attributes
compareElementVisuals method in Base component does everything required for validating the webElement against the JSON Baselin
The method takes current Page Name, TestTarget, WebElement variable and WebElement name as parameters
Following is a sample method for checking Search Bar on the main navigation for on the home page

```java
public Map<String,String> checkSearchBar(String pageName, TestTarget target) throws FrameworkException{
        return this.compareElementVisuals(pageName, target, this.searchBar, "searchBar");
}
```
It returns the Map which has Each element attribute and it's validation status.

### Sample UI Test
This how a sample UI Tests looks like
```java
    @Test(description = "Validate Search Bar on the home page")
    public void validateSearchBar() throws FrameworkException {
        HomePage homePage = new HomePage(this.getDriver());
        StringBuilder reportRec = this.getReportLine("Task: 1, Test Name: Validate Search Bar",homePage.mainNavBar.getLocator("searchBar"),this.testTarget );
        Map<String, String> compareResult = homePage.mainNavBar.checkSearchBar("homePage", this.testTarget);
        SoftAssert softAssert = this.runUIValidationForElement(compareResult, reportRec);
        softAssert.assertAll();    
    }
```
runUIValidation method will take the Map returned by the checkSearchBar method and run the soft assertions to validation each attribute

### Reporting
While the soft assertions are run, a report is also generated which records the status of each Element's UI Validation. The report is present in the Output directory with timestamp
If all Validation against the Baseline values for elements in the JSON match the Status of the test in the report will be passed as follows
```
Task: 1, Test Name: Validate ApplitoolsLogo, DOM ID: logo, Browser: CHROME, Viewport: 500X700, Device: iPhone X, Status:Pass
```
If UI Validations against the Baseline fail then Status will be failed and Reason for failure is also mentioned
In the following case, As per baseline JSON Search Button should not visible for Target Browser chrome with size - 500 X 700 however it's visible hence the test has failed
```
Task: 1, Test Name: Validate search button, DOM ID: BUTTONsubmit____43, Browser: CHROME, Viewport: 500X700, Device: iPhone X, Status:Fail Reason: expected visibility  false actual visibility true
```

### Getting Started
For Starting UI Testing following steps can be followed
1. Start By creating components and pages Java classes
2. Once pages and components are ready, start creating JSON baselines for Pages
Following is the Sample HomePage baseline with AppHeader Component
```json
{
    "AppHeader" : {
        "child_elements" : [
            {
                "element_name" : "applitoolsLogo",
                "isDisplayed" : true,
                "element_size" : {
                    "height" : 35,
                    "width" : 150
                },
                "element_location" : {
                    "X" : 15,
                    "Y" : 16
                }
            },
            {
                "element_name" : "mainMenu",
                "isDisplayed" : true,
                "element_size" : {
                    "height" : 68,
                    "width" : 580
                },
                "element_location" : {
                    "X" : 310,
                    "Y" : 0
                }
            },
            {
                "element_name" : "homeMenu",
                "isDisplayed" : true,
                "element_size" : {
                    "height" : 68,
                    "width" : 90
                },
                "element_location" : {
                    "X" : 310,
                    "Y" : 0
                }
            },
            {
                "element_name" : "menMenu",
                "isDisplayed" : true,
                "element_size" : {
                    "height" : 68,
                    "width" : 81
                }
            }
        ]
    }
 ```
4. Start writing UI Validations tests
5. You can provide any random values in the beginning. Run the test and report will tell you the actual values for each attribute
6. Review the report, check each element on the UI and update baseline as required. 
7. It's not necessary to validate each attribute for every element. Only attributes mentioned in the Baseline JSON will be validated. Rest will be ignored.
In the above case for MenMenu only visibility and size will be validated whereas for homeMenu Size, Location and visibility will be checked
    


    

 
