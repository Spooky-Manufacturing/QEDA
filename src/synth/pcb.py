
from numpy import array
from pykicad.pcb import Net, Via, Segment, Setup, Layer, NetClass, Pcb

class PCB:
    def __init__(self, config, title="Quantum PCB Output", comments=[]):
        vi_net, vo_net, gnd_net = Net('VI'), Net('VO'), Net('GND')
        self.nets = [vi_net, vo_net, gnd_net]
        self.modules = []
        self.vias = []
        self.zones = []
        self.segments = []
        print(config.sections())
        self.via_size = float(config['DEFAULT']['via_size'])
        self.drill_size = float(config['DEFAULT']['drill_size'])
        self.clearance = float(config['DEFAULT']['clearance'])
        self.num_layers = int(config['DEFAULT']['layers'])
        self.layers = []
        self.page_type = [int(x) for x in config['DEFAULT']['page_type'].split(',')]
        self.trace_width = config['DEFAULT']['trace_width']
        self.coords = [(0,0), (10,0), (10,10), (0,10)]
        self.title = title
        self.comment1 = None
        self.comment2 = None
        self.comment3 = None
        self.comment4 = None
        if len(comments) > 0:
            self.comment1 = comments[0]
            if len(comments) > 1:
                self.comment2 = comments[1]
                if len(comments) > 2:
                    self.comment3 = comments[2]
                    if  len(comments) > 3:
                        self.comment4 = comments[3]
        self.grid_origin = [int(x/2) for x in self.page_type]
        self.setup = Setup(grid_origin=self.grid_origin)

    def _connect_pad(self, comp, pad, net):
        """Connects component pads electrically.
        Var     Type        Description
        comp    Module      component class
        pad     Integer     component pad number
        net     Net         NetClass
        """
        comp.pads[pad].net = self.nets[net]

    def _place_component(self, comp, x_pos, y_pos):
        """
        Places component comp at position (x,y)
        and adds it to the PCB layout.
        """
        comp.at = [x_pos, y_pos]
        self.modules.append(comp)
    
    def _final_compute(self, comp):
        """
        Computes the positions of vias for quantum optical components.
        """
        start = array(comp.pads[1].at) + array(comp.at)
        end = array(comp.pads[0].at) + array(comp.at)
        pos = start + (end - start) / 2
        self._create_via(pos, self.nets[1].code)
        return start, end, pos

    def _compute_positions(self, comp1, comp2, pads=[1,0], create_vias=True):
        """
        Computes the positions of vias.
        Var     Type        Description
        comp1   Module      Module for component 1
        comp2   Module      Module for component 2
        pads    Int[]       List of integers of pads (only 2 can be connected at a time)
        create_vias Bool    Create vias (default: True)
        """
        start = array(comp1.pads[pads[0]].at) + array(comp1.at)
        end = array(comp2.pads[pads[1]].at) + array(comp2.at)
        pos = start + (end - start) / 2

        if create_vias:
            self._create_via(pos, self.nets[1].code)
        return start, end, pos

    def _create_via(self, pos, net=None, via_size=None, drill_size=None):
        """
        Creates the size
        Var         Type            Description
        pos         (float,float)   (x,y) position of component
        net         Net             Net class of via
        via_size    float           Size of via (overrides self.via_size)
        drill_size  float           Size of drill (overrides self.drill_size)
        """
        if not via_size:
            via_size = self.via_size
        if not drill_size:
            drill_size = self.drill_size
        
        self.vias.append(Via(at=pos.tolist(), size=via_size, drill_size=drill_size, net=net))

    def _create_segment(self, start, end, net):
        """
        Creates segments and appends them to list
        """
        self.segments.append(Segment(
            start=start.tolist(),
            end=end.tolist(),
            net=net.code
        ))

    def _create_zones(self):
        """
        Creates the zones (layers) of the PCB
        """
        self.layers = [
            Layer('F.Cu'),
            Layer('Inner1.Cu'),
            Layer('Inner2.Cu'),
            Layer('B.Cu'),
            Layer('Edge.Cuts', type='user')
        ]

        for layer in ['Mask', 'Paste', 'SilkS', 'CrtRd', 'Fab']:
            for side in ['B', 'F']:
                self.layers.append(Layer("{}.{}".format(side, layer), type='user'))
        
        self.net_classes = NetClass(
            'default',
            trace_width=self.trace_width,
            nets=['VI','VO','GND'])

    def _create_pcb(self):
        pcb = Pcb()
        pcb.title = self.title
        pcb.comment1 = self.comment1
        pcb.comment2 = self.comment2
        pcb.comment3 = self.comment3
        pcb.comment4 = self.comment4
        pcb.page_type = self.page_type
        pcb.num_nets = len(self.nets)
        pcb.setup = self.setup
        pcb.layers = self.layers
        pcb.modules = self.modules
        pcb.net_classes = self.net_classes
        pcb.nets = self.nets
        pcb.vias = self.vias
        pcb.zones = self.zones
        pcb.to_file('project')