BUIlD_DIR := bin/
build:
	javac src/com/cml23/lox/*.java -d $(BUIlD_DIR)
repl:
	java -cp bin com.cml23.lox.Lox 
run:
	java -cp bin com.cml23.lox.Lox $(SCRIPT)
generate:
	javac src/com/cml23/tool/*.java -d $(BUIlD_DIR)
	java -cp bin com.cml23.tool.GenerateAst src/com/cml23/lox
.PHONY: repl