#!/usr/bin/python3
import sys
import os
from antlr4 import *
from OpenQASM.qasm3Lexer import qasm3Lexer
from OpenQASM.qasm3Parser import qasm3Parser
#from OpenQASM.QEDAListener import QEDAListener as Listener
from OpenQASM.QEDAListener2 import QEDAListener as Listener
def main(argv):
    a = argv[1]
    if('-a' in a):
        return allTest()
    input_stream = FileStream(a,encoding='utf-8')
    lexer = qasm3Lexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = qasm3Parser(stream)
    tree = parser.program()
    listener = Listener(argv[1])
    walker = ParseTreeWalker()
    walker.walk(listener, tree)
    print("Header: {}".format(listener.HEADER))
    print("Globals: {}".format(listener.GLOBALS))
    print("Locals: {}".format(listener.LOCALS))
def allTest():
    files = ['./examples/' + x for x in os.listdir("./examples") if '.qasm' in x]
    failed = []
    succeeded = []
    for f in files:
        try:
            print("Trying File {}".format(f))
            main([0,f])
            succeeded.append(f)
            print("Success!")
        except Exception as e:
            print("Failed :(")
            failed.append(
                {
                    'file':f,
                    'error':e
                }
            )
    print("Success Rate: {:.0%}".format(len(succeeded)/len(files)))
    if(len(failed)==0):
        print("Failed Files: None!")
    else:
        print("Failed Files:")
        for each in failed:
            print(each['file'])
            print("Error: ", each['error'])
if __name__ in '__main__':
    main(sys.argv)
