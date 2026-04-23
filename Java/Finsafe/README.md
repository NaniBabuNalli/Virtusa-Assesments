# Java: The "FinSafe" Transaction Validator

### 📖 Business Case
"FinSafe" is a digital wallet app requiring a robust processor to prevent "Overdraft" errors and provide clear transaction feedback.

### 🚀 Key Features
**Encapsulation**: Utilizes an `Account` class with private variables to protect user balances.       
**Custom Exceptions**: Implements `InSufficientFundsException` for graceful error handling during overdrafts.         
**Input Validation**: Checks for illegal arguments (negative amounts) before processing.              
**Transaction History**: Uses an `ArrayList` to store and display a "Mini Statement" of the last 5 transactions. 

### 🛠 How to Run
```bash
javac *.java
java FinSafeApp
