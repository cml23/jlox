build:
	javac com/cml23/lox/*.java
repl:
	java com/cml23/lox/Lox $(SCRIPT)
.PHONY: lox