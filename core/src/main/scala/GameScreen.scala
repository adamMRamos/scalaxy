package com.angry.micro.raptor.scalaxy

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera, Texture}
import com.badlogic.gdx.math.Rectangle

/**
  * Created by amram on 5/14/2018.
  */
class GameScreen(scalaxy: Scalaxy) extends Screen {
    private val img: Texture = new Texture("badlogic.jpg")
    private val camera: OrthographicCamera = new OrthographicCamera()
    this.camera.setToOrtho(false, 800, 480)

    private val rect = new Rectangle()

    override def resume(): Unit = {}
    override def show(): Unit = {}
    override def pause(): Unit = {}
    override def hide(): Unit = {}
    override def resize(width: Int, height: Int): Unit = {}
    override def dispose(): Unit = this.img.dispose()

    override def render(delta: Float) {
        import com.badlogic.gdx.Gdx
        // clear the screen with a dark blue color. The// clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        this.camera.update()
        scalaxy.batch.setProjectionMatrix(this.camera.combined)

        scalaxy.batch.begin()
        scalaxy.batch.draw(this.img, 0, 20)
        scalaxy.batch.end()
    }
}

