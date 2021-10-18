
class Symbol:
    """
        Schematic symbols.


    """
    def __init_(self, inputs, outputs):
        self.inputs = inputs
        self.outputs = outputs
        pass

    def gen_symbol(self):
        """Generates a new kicad symbol"""

        """
        input pins should be right-orientation
        non-electrical (optical) pins should be Open Collectors
        pin names should be user-def input name
        pin numbers assigned in order (left top-bottom, right top-bottom)
        inputs = [
            {
                'pin name':,
                'pin num':,
                'orientation',
                'electrical type',
                'graphic style',
            }
        ]
        
        """
        pass