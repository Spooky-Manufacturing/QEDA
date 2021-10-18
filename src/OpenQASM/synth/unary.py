


class U:
    """The core unary gate"""
    def __init__(self, theta=None, phi=None, lamda=None):
        self.theta=theta
        self.phi=phi
        self.lamda=lamda

    def decompose(self):
        """
        Decomposes the gate into a set of optical components
        """
        pass