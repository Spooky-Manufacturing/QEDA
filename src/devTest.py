#!/usr/bin/python3
"""
Usage:

./devTest.py file
./devTest.py -a

-a      Runs all examples in ./examples/
file    path to a qasm file
"""
import sys
import os
from antlr4 import FileStream, CommonTokenStream, ParseTreeWalker
from OpenQASM.qasm3Lexer import qasm3Lexer
from OpenQASM.qasm3Parser import qasm3Parser
from OpenQASM.QEDAListener import QEDAListener as Listener
from OpenQASM.synthesizer import Synthesizer

testSynth = True

def main(argv):
    """
    Main function.

    Loads and parses the files then prints
    the intermediate representation output.
    """
    global testSynth
    arg = argv[1]
    if '-a' in arg:
        return all_tests()
    input_stream = FileStream(arg, encoding='utf-8')
    lexer = qasm3Lexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = qasm3Parser(stream)
    tree = parser.program()
    listener = Listener(argv[1])
    walker = ParseTreeWalker()
    walker.walk(listener, tree)
    if testSynth == False:
        print("Header: {}".format(listener.HEADER))
        print("Globals: {}".format(listener.GLOBALS))
        print("Locals: {}".format(listener.LOCALS))
    else:
        synth = Synthesizer(listener.HEADER, listener.GLOBALS, listener.LOCALS, debug=True)


def all_tests():
    """Runs all the tests in ./examples folder
    (useful for quick debugging of new features)
    """
    files = ['./examples/' + x for x in os.listdir("./examples") if '.qasm' in x]
    failed = []
    succeeded = []
    for file in files:
        try:
            print("Trying File {}".format(file))
            main([0, file])
            succeeded.append(file)
            print("Success!")
        except Exception as err:
            print("Failed :(")
            failed.append(
                {
                    'file':file,
                    'error':err
                }
            )
    print("Success Rate: {:.0%}".format(len(succeeded)/len(files)))

    if(len(failed) == 0):
        print("Failed Files: None!")
    else:
        print("Failed Files:")
        for each in failed:
            print(each['file'])
            print("Error: ", each['error'])

if __name__ in '__main__':
    main(sys.argv)
