### 4. Python: OpsBot Log Automator README
**File Name:** `Python_OpsBot/README.md`


# Python: The "OpsBot" Log Automator

### 📖 Business Case
IT Operations teams often waste hours manually scanning logs for threats. OpsBot automates this by filtering 5,000+ lines of data in seconds. 

### 🚀 Key Features
* **File Parsing**: Reads raw `server.log` files line-by-line for memory efficiency. 
* **Security Filtering**: Identifies `CRITICAL`, `ERROR`, and `FAILED LOGIN` attempts using pattern matching. 
* **Frequency Mapping**: Uses a Python Dictionary to count the occurrence of different error types. 
* **Automated Reporting**: Generates a timestamped `security_alert.txt` file and validates its creation using the `os` module. 

### 📄 Deliverables
* `OpsBot.py`: The main automation script. 
* `server.log`: Sample raw data for testing.
