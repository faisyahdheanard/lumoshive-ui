@CHECKOUT
Feature: End-to-end Checkout Flow for User Purchasing Test

  Background:
    Given Navigate to the website

  @CHECKOUT01
  #CUSTOMER DETAILS DATA : NAME, EMAIL, PHONE NO
  Scenario: Successfully Completes Purchase Process Using Credit Card as Payment Method
    When Click the BUY NOW button
    And Input "40000" for the amount of the price on price field
    And Input the Name field
    And Input the Email field
    And Input the Phone no field
    And Input the City field
    And Input the Address field
    And Input the Postal code field
    And Click the CHECKOUT button
    And Click the Credit or Debit Card button
    And Input the Card number field with "valid" Card number
    And Input the Expiration date field with "valid" Expiration date
    And Input the CVV field with "valid" CVV
    And Select "Proceed without promo" on the promo option

    Then Ensure the total amount is "40000"
    When Click the Pay Now button

    Then The info about the Issuing Bank is displayed
    When Input the Password field
    And Click the OK button

    Then The message saying "Payment Successful" is displayed
    And Be directed back to the Main Page
    And The success message is displayed


  @CHECKOUT02
  Scenario: Failed to Completes Purchase Process Using Credit Card as Payment Method
    When Click the BUY NOW button
    And Input "40000" for the amount of the price on price field
    And Input the Name field
    And Input the Email field
    And Input the Phone no field
    And Input the City field
    And Input the Address field
    And Input the Postal code field
    And Click the CHECKOUT button
    And Click the Credit or Debit Card button
    And Input the Card number field with "invalid" Card number
    And Input the Expiration date field with "invalid" Expiration date
    And Input the CVV field with "invalid" CVV
    And Select "Proceed without promo" on the promo option
    Then Ensure the total amount is "40000"

    When Click the Pay Now button
    Then The info about the Issuing Bank is displayed

    When Input the Password field
    And Click the OK button
    Then The message saying "Payment declined by bank" is displayed

    When Click the Back button
    Then Be directed back to the Main Page
    And The message indicating the reason for the failure is displayed
