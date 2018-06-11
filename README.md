# loanCalculater
# This directory contains:
* README.md
* quote.exe file
* quote.jar file which is same as quote.exe(just in case .exe file doesn't work), use command ```java -jar [market_file] [loan_amount] ``` to run
* a zip file which is the whole maven project. You can also clone it   ```git clone https://github.com/zhangyi667/loanCalculater.git```
* You can always run ```mvn package``` to build a jar file which is ready to use.

## Brief description of the project
* A simple maven project, compiled and run in Java 8
* Source files are in src/main/java. It consists of 3 modules, the Calculater, the FileParser and Util. 
* Test files are in src/test/java. Using JUnit as test framework.

## My understanding of the project
Basically the system works like this: Some people lend their money to Zopa, and Zopa lends these money out. The profit comes from the interest differences. 
First, we have a csv file which contains all the money and interests from lenders, from which we can calculate how much money we have in the pool, and how much the interests are(In 3 years). Let's say the interests in total are N.
Then, when somebody wants a quote from us, the lowest rate comes when the total repayment of him/her is equal to N(And in this case our profit is exactly 0). This is how it works.
As we know the requested amount and period to pay of a person, we know the total repayment, and thus comes how to calculate annual rate. What I do is to use binary search to guess the rate using PMT formula. I also found that in Excel it has a RATE formula, which I used to generate test data. In my project file src/main/resources/rate data for test.xlsx I randomly generated some data that I can do assertion in the tests.

## Assumptions
* compile and run in Java 8.
* Currency comes in pound as sterling.
* When calculating the rate, assume the max rate is 100%.
* Had the input is invalid, as null params, wrong path of file, file data invalid, etc. The programe would throw exception.

## TODO
Because of the time limit and assumptions I made, there are a few known improvements.
* It only accepts .csv file. Any file without format or with wrong format would throw Exception.
* The data in csv file have to be valid. Or it would throw NumberFormatException.
* No i18n or localizations. 
* No logs.