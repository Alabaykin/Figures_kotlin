class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Figure(0), Transforming {
    var color: Int = -1
    lateinit var name: String

    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun area(): Float {
        return (width * height).toFloat()
    }

    override fun resize(zoom: Int) {
        width *= zoom
        height *= zoom
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

        val temp = width
        width = height
        height = temp
    }

    override fun toString(): String {
        return "Rect(x=$x, y=$y, w=$width, h=$height)"
    }
}