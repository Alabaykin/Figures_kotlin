class Circle(var x: Int, var y: Int, var radius: Int) : Figure(0), Movable, Transforming {

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun area(): Float {
        return (Math.PI * radius * radius).toFloat()
    }

    override fun resize(zoom: Int) {
        radius *= zoom
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
        return "Circle(x=$x, y=$y, r=$radius)"
    }
}