# Guide to Execute and Collect Results from E2E Automation Suite

 The repository to maintain all the Asgardeo focused test automation and other QA artifacts related to IAM e2e automation suite on Asgardeo. The automation suite  is
 implemented with [Cypress](https://www.cypress.io) [9.7.0](https://docs.cypress.io/guides/references/changelog) test automation framework.

## Prerequisites
1. [Install Node js](https://nodejs.org/en/download/) (support: npm 8 and above)

## Test execution against Local setup

****Prerequisite : Setup the local environment****

1. Git Clone the Repo with the master branch for the the specified location.

```bash
git clone https://github.com/wso2-enterprise/asgardeo-tests.git
```

2. Open terminal at the repository root location and install all the dependencies specified in the package.json file via npm by executing below command.

```bash
npm install
```

3. When executing the whole test suite there are some environment variables in [cypress.env.local.json](https://github.com/wso2-enterprise/asgardeo-tests/blob/re-structure-e2e/cypress.env.local.json) where values are not committed due to the sensitivity of those data.
Therefore these should be updated manually. This can be updated as follows:

* We have sample test configurations which are listed in this [doc](https://docs.google.com/document/d/1TGaq9i8_m07f-jGb6ZAZqBqfbNbQHrtPriGB1Jrs5mg/edit#bookmark=id.1b68pfoelkav) which are default created by local setup

    0R

* Creating your own test data and update the configs accordingly

> ****Note****:
> * For both ways, super tenant will be ****admin****
> * There are default configurations that are already updated in the cypress.env.local.json file. Any deviation from the default values should be updated in the file accordingly.  

4. The automation suite can be executed in 2 ways:

* ****Execute Automation Suite in Headless mode -- Recommended****

Open terminal at the repository root location and execute the Cypress Automation Test Suite by executing the below command

```bash
npm run test-norecord:local
```

> ****Note****: The `norecord` is added to ignore record flag for cypress dashboard

If you need to execute only a certain group of test cases. You can use the following commands:

> For application :

```bash
npm run sub:applications --env environment=local
```

> For users :

```bash
npm run sub:users --env environment=local
```

> For tenants :

```bash
npm run sub:tenant --env environment=local
```

* ****Execute Automation Suite in Head-on (UI) mode****

Open terminal at the repository root location and Execute the below command

```bash
npx cypress open --env environment=local
```

Click on "Run test" in the Cypress Test Runner.

## Test execution against Test Pipeline (Dev environment)

1. Git Clone the Repo with the master branch for the the specified location

```bash
git clone https://github.com/wso2-enterprise/asgardeo-tests.git
```

2. Switch to branch re-structure-e2e

3. Open terminal at the repository root location and install all the dependencies specified in the package.json file via npm by executing below command.

```bash
npm install
```

4. When executing the whole test suite, there are some environment variables in [cypress.env.json](https://github.com/wso2-enterprise/asgardeo-tests/blob/re-structure-e2e/cypress.env.json) where values are not committed due to the sensitivity of those data. Therefore these should be updated manually as follows:

* We have sample test configurations which are listed in this [doc](https://docs.google.com/document/d/1TGaq9i8_m07f-jGb6ZAZqBqfbNbQHrtPriGB1Jrs5mg/edit#bookmark=id.1b68pfoelkav) which can be used

    0R

* Creating your own test data and update the configs accordingly

    > ****Note****:
    > * For both ways, super tenant details should be retreived from QA
    > * There are default configurations that are already updated in the `cypress.env.json` file. Any deviation from the default values should be updated in the file accordingly.

5. The automation suite can be executed in 2 ways:

* ****Execute Automation Suite in Headless mode -- Recommended****

Open terminal at the repository root location and execute the Cypress Automation Test Suite by executing the below command

```bash
npm run test-norecord
```

> ****Note****: No record is added to ignore record flag for cypress dashboard

* ****Execute Automation Suite in Head-on (UI) mode****

Open terminal at the repository root location and Execute the below command

```bash
npx cypress open
```

Click on "Run test" in the Cypress Test Runner

Find more variations of test execution in this document : https://docs.google.com/document/d/1e38iVFsdjXgj1Oq_2Zyrm9omm0w5yJT13tSAqXURTqQ/edit#heading=h.1pcof9marrul

## Collecting Test Results

We have integrated Mocha with Cypress to generate a report with a test execution summary.
Cypress is built on top of Mocha Javascript Framework, therefore any reporter built for Mocha can be used with Cypress.

* ****Report**** :

Generated reports can be found at

> cypress/reports/mochareports/report.html

* ****Screenshots**** :

Screenshot will be created at test failure and can be found at

> cypress/reports/screenshots

* ****HAR Files**** :

HAR files  will be created at test failures and can be found at

> cypress/hars

* ****Videos**** :

To enable this feature, you can set `"video": true` in [cypress.json](https://github.com/wso2-enterprise/asgardeo-tests/blob/re-structure-e2e/cypress.json) file. Test recordings can be found at

> cypress/videos

## Content of the Suite

1. [**Configs**](https://github.com/wso2-enterprise/asgardeo-tests/tree/re-structure-e2e/cypress/configs) contain the configuration properties such as wait times, accessing environment variables, task names and product endpoints.

2. [**Constants**](https://github.com/wso2-enterprise/asgardeo-tests/tree/re-structure-e2e/cypress/constants) contain any hard coded keywords, endpoints, html elements and other string patterns that are required.

3. [**Fixtures**](https://github.com/wso2-enterprise/asgardeo-tests/tree/re-structure-e2e/cypress/fixtures) are external pieces of static data that can be used by your tests. We should not hard code data in the
 test case. It should drive from an external source like CSV, HTML, or JSON. They will be majorly used with the cy.fixture() command when you need to stub the network calls.

4. [**Plugins**](https://github.com/wso2-enterprise/asgardeo-tests/tree/re-structure-e2e/cypress/plugins) contain the plugins or listeners. By default, Cypress will automatically include the plugins file `cypress/plugins/index.js` before every test it runs. You can programmatically alter the resolved configuration and environment variables using plugins.

    Eg: If we have to inject customized options to browsers like accepting the certificate, or do any activity on test case pass or fail or to handle any other events like handling screenshots, they enable you to extend or modify the existing behavior of Cypress.

5. [**Support**](https://github.com/wso2-enterprise/asgardeo-tests/tree/re-structure-e2e/cypress/support) writes customized commands or reusable methods that are available for usage in all of your spec/test
 files. This file runs before every single spec file. That’s why you don’t have to import this file in every single one of your spec files.  The “support” file is a great place to put reusable behavior such as Custom Commands or global overrides that you want to be applied and available to all of your spec files.

6. [**Page Objects**](https://github.com/wso2-enterprise/asgardeo-tests/tree/re-structure-e2e/cypress/page-objects) contain the Page UI getters for the element locators. This should only include the element locators and their getters.

7. [**E2E**](https://github.com/wso2-enterprise/asgardeo-tests/tree/re-structure-e2e/cypress/e2e) folder include the test specs. Spec files included the test case that is automated to test a function of the application. To perform this, we need certain configurations, hard coded strings, urls, status codes, actions and assertions. This should be written as :

* Page elements should be retrieved from the “Page object” folders
* Configuration properties should be retrieved from the “Config” folders
* Hard coded string, status codes, keywords should be retrieved from “Constants” folders
* Common actions, assertions should be retrieved from the support files.
* Specific actions, assertions should be included in the spec file

8. [**Cypress.json**](https://github.com/wso2-enterprise/asgardeo-tests/blob/re-structure-e2e/cypress.json) is used to store different configurations. E.g., timeout, base URL, test files, or any other
 configuration that we want to override for tweaking the behavior of Cypress.

9. [**Package.json**](https://github.com/wso2-enterprise/asgardeo-tests/blob/re-structure-e2e/package.json) carries the npm package meta data and also the npm scripts to simply call the test groups to execute

## More info

Please refer the complete E2E Automation Suite guide here : https://docs.google.com/document/d/1e38iVFsdjXgj1Oq_2Zyrm9omm0w5yJT13tSAqXURTqQ/edit?usp=sharing
