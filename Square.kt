class Square(var x: Int, var y: Int, var side: Int) : Figure(0), Movable, Transforming {

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun area(): Float {
        return (side * side).toFloat()
    }

    override fun resize(zoom: Int) {
        side *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val rx = x - centerX
        val ry = y - centerY

        when (direction) {
            RotateDirection.Clockwise -> {
                x = centerX + ry
                y = centerY - rx
            }
            RotateDirection.CounterClockwise -> {
                x = centerX - ry
                y = centerY + rx
            }
        }
    }

    override fun toString(): String {
        return "Square(x=$x, y=$y, side=$side)"
    }
}