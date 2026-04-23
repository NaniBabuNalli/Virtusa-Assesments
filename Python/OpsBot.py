import os
from datetime import datetime

def run_ops_bot(log_filename):
    error_counts = {"CRITICAL": 0, "ERROR": 0, "FAILED LOGIN": 0}
    security_alerts = []

    try:
        with open(log_filename, 'r') as file:
            for line in file:
                # Pattern Matching
                if "CRITICAL" in line or "ERROR" in line or "FAILED LOGIN" in line:
                    security_alerts.append(line.strip())
                    for key in error_counts:
                        if key in line:
                            error_counts[key] += 1

        # Report Generation
        report_date = datetime.now().strftime("%Y-%m-%d")
        report_filename = f"security_alert_{report_date}.txt"
        
        with open(report_filename, 'w') as report_file:
            report_file.write(f"--- SECURITY ALERT SUMMARY ({report_date}) ---\n")
            report_file.write(f"Total Errors Found: {error_counts}\n")
            for alert in security_alerts:
                report_file.write(alert + "\n")

        
        file_size = os.path.getsize(report_filename)
        log_size = os.path.getsize(log_filename)
        print(f"Success! OpsBot has created: {report_filename}")
        print(f"Alert File Size: {file_size} bytes")
        print(f"Log File Size: {log_size} bytes")
        print(f"Reduced Size by: {log_size - file_size} bytes")
        print(f"Summary: {error_counts}")

        

    except FileNotFoundError:
        print(f"Error: The file '{log_filename}' was not found.")



run_ops_bot("/Users/nanibabunalli/Desktop/IMP /Python/server.log")