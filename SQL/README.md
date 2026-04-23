# SQL: The "Digital Library" Audit

### 📖 Business Case
A community college needs to track overdue books and identify popular genres to optimize their purchasing strategy.

### 🚀 Key Features
* **Relational Schema**: Designed `Books`, `Student`, and `IssuedBooks` tables with Foreign Key constraints. 
* **Penalty Report**: Logic to identify students holding books for over 14 days without returning them. 
* **Popularity Index**: Aggregated data using `GROUP BY` to rank book categories by demand. 
* **Data Cleanup**: Automated removal of inactive student accounts (not borrowed in 3+ years). 

### 📊 Queries Included
1. [cite_start]Table Creation (DDL) 
2. Overdue Identification Logic
3. Popularity & Genre Analysis
