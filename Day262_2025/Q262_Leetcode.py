class Spreadsheet:
    def __init__(self, rows: int):
        self.cells = {}

    def setCell(self, cell: str, value: int) -> None:
        self.cells[cell] = value

    def resetCell(self, cell: str) -> None:
        if cell in self.cells:
            del self.cells[cell]

    def getValue(self, formula: str) -> int:
        idx = formula.find('+')
        left = formula[1:idx]   # skip '='
        right = formula[idx+1:]

        valLeft = self.cells.get(left, 0) if left[0].isalpha() else int(left)
        valRight = self.cells.get(right, 0) if right[0].isalpha() else int(right)

        return valLeft + valRight
