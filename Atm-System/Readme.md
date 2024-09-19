# ATM System Design

## Overview
This project involves designing a simple ATM system that lets users perform essential banking tasks such as checking their balance, withdrawing cash, and depositing money. The system connects to the bank’s backend to ensure transactions are valid and secure.

## Key Features
1. **Basic Operations**: Users can check their account balance, withdraw cash, and deposit money.
2. **User Authentication**: Users must verify themselves with a card and a PIN (Personal Identification Number) to access their account.
3. **Bank Integration**: The ATM communicates with the bank’s backend to validate accounts and complete transactions.
4. **Cash Dispensing**: The ATM has a mechanism to dispense cash.
5. **Concurrency**: The system can handle multiple users at the same time, ensuring data remains consistent.
6. **User-Friendly Interface**: The system includes an easy-to-use interface for users to interact with the ATM.


## Classes, Interfaces, and Enumerations

1. **Card**: Represents the ATM card that includes the card number and PIN for user authentication.
2. **Account**: Represents a user's bank account. It stores the account number and balance and has methods for debiting and crediting funds.
3. **Transaction**: An abstract class that serves as the base for specific transactions like withdrawals and deposits. Other classes, such as `WithdrawalTransaction` and `DepositTransaction`, extend this.
4. **BankingService**: Manages the bank accounts and handles transactions. It uses thread-safe methods (like `ConcurrentHashMap`) to ensure smooth performance when many users access it at once.
5. **CashDispenser**: Represents the ATM's mechanism to dispense cash. It ensures thread safety while dispensing cash.
6. **ATM**: Acts as the main interface for users to interact with the ATM. It handles user authentication, balance inquiries, withdrawals, and deposits by interacting with the `BankingService` and `CashDispenser`.
7. **ATMDriver**: Demonstrates the system by creating sample accounts and performing various ATM operations such as balance inquiry, withdrawal, and deposit.

