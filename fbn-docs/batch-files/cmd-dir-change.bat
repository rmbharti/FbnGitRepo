reg add "HKEY_CURRENT_USER\Software\Microsoft\Command Processor" /v AutoRun /t REG_SZ /d "IF x"%COMSPEC%"==x%CMDCMDLINE% (cd /D C:\Users\admin\Desktop\AWS-Workspace\fbn-batch\local)"