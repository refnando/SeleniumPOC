## SeleniumPOC

Java Selenium TestNG Automation Tests

## Description

This project demonstrates automated tests using Java, Selenium, and TestNG framework. The tests cover various scenarios related to user login, product sorting, shopping cart, and purchase completion.

## Test Scenarios

1. **Login with a valid user.**
   - **Expected:** Validate that the user is successfully navigated to the products page after logging in.

2. **Login with an invalid user.**
   - **Expected:** Validate that an error message is displayed indicating invalid login credentials.

3. **Logout from the home page.**
   - **Expected:** Validate that the user is navigated to the login page after logging out.

4. **Sort products by Price (low to high).**
   - **Expected:** Validate that the products are sorted correctly based on their prices in ascending order.

5. **Add multiple items to the shopping cart.**
   - **Expected:** Validate that all the selected items are successfully added to the shopping cart.

6. **Add the specific product 'Sauce Labs Onesie' to the shopping cart.**
   - **Expected:** Validate that the 'Sauce Labs Onesie' product is added to the shopping cart accurately.

7. **Complete a purchase.**
   - **Expected:** Validate that the user is navigated to the order confirmation page after successfully completing the purchase.

## Setup Instructions

1. Clone this repository to your local machine.
2. Ensure you have Java, Selenium, and TestNG installed.
3. Set up the required WebDriver for your preferred browser (e.g., ChromeDriver for Google Chrome).
4. Configure the WebDriver path in the test scripts.
5. Run the tests using your preferred test runner or IDE.

## Additional Notes

- The test scripts are located in the "src/test" directory.
- Test data, such as valid and invalid user credentials, can be configured in the test scripts or fetched from external sources.
- Test reports and logs will be generated after test execution.
- TestNG annotations and assertions are used for test organization and result verification.

Feel free to explore and enhance the test suite as needed to meet your specific requirements.

## Contributors

- [Fernando](https://github.com/refnando)

## License

This project is licensed under the [MIT License](LICENSE).
