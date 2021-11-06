from math import ceil
from pykicad.module import Module
from OpenQASM.pcb import PCB

class Synthesizer:
    def __init__(self, file='./', circ=None):
        self.file = file.split('/')[-1:][0]
        self.pcb = PCB()
        self.qcirc = {}
        self.circ = circ

    def schema_capture(self):
        print("SCHEMATIC CAPTURE")
        print(self.file)
        with open(self.file + '.schema', 'w+') as f:
            f.write(str(self.circ))

    def pcb_layout(self):
        print("PCB LAYOUT")
        self._autoplace_()

    def _find_max_x(self, comp):
        """
        Returns the maximal X size of a Component as an Integer
        """
        max_x = 0
        geo = comp.geometry()
        x = [each for each in geo]
        for each in x:
            if each.start is None and each.end is not None:
                y = abs(0 - each.end[0])
            elif each.end is None and each.start is not None:
                y = abs(each.start)
            elif each.start == each.end and each.end is None:
                pass
            else:
                y = abs(each.start[0] - each.end[0])
                if y > max_x:
                    max_x = y
        return ceil(max_x)

    def _find_max_y(self, comp):
        """
        Returns the maximal Y size of a Component as an Integer
        """
        max_y = 0
        geo = comp.geometry()
        x = [each for each in geo]
        for each in x:
            if each.start is None and each.end is not None:
                y = abs(0 - each.end)
            if each.end is None and each.start is not None:
                y = abs(each.start)
            elif each.start == each.end and each.end is None:
                pass
            else:
                y = abs(each.start[1] - each.end[1])
                if y > max_y:
                    max_y = y
        return ceil(max_y)

    def _find_maxes(self, comp):
        """
        Returns the maximal X and Y values of a component
        """
        x = self._find_max_x(comp)
        y = self._find_max_y(comp)
        return int(x), int(y)

    def _place_component(self, comp, x, y):
        """Places the component at coordinates (x,y)"""
        self.pcb._place_component(comp, x, y)
    
    def _autoplace_(self):
        pos = {
            'X':0,
            'Y':0
        }
        cur_x = 0
        cur_y = 0
        for qubit, gates in self.circ.items():
            print(qubit, gates)