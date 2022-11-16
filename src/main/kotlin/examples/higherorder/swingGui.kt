package examples.higherorder

import java.awt.Component
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel

fun main() {
    val (window, label) = initWindow()

    val button = JButton("Click me")

    var n = 0

    button.alignmentX = Component.CENTER_ALIGNMENT
    button.addActionListener {
        n += 1
        label.text = "You clicked $n times!"
    }
    window.contentPane.add(button)


    window.isVisible = true
}

fun initWindow(): Pair<JFrame, JLabel> {
    val window = JFrame("CSD215 Lab 4")
    window.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    window.setSize(400, 300)

    window.contentPane.layout = BoxLayout(window.contentPane, BoxLayout.Y_AXIS)

    // Add label
    val label = JLabel("Hello, World!")
    label.alignmentX = Component.CENTER_ALIGNMENT
    window.contentPane.add(label)

    return Pair(window, label)
}