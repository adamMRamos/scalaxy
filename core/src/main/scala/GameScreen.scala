package com.angry.micro.raptor.scalaxy

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.{OrthographicCamera, Texture}

/**
  * Created by amram on 5/14/2018.
  */
class GameScreen(scalaxy: Scalaxy) extends Screen {
  private var img: Texture = new Texture("badlogic.jpg")
  private var camera: OrthographicCamera = new OrthographicCamera()
  this.camera.setToOrtho(true, 800, 480)

  override def resume(): Unit = ???

  override def show(): Unit = ???

  override def pause(): Unit = ???

  override def hide(): Unit = ???

  override def resize(width: Int, height: Int): Unit = ???

  override def dispose(): Unit = ???

  override def render(delta: Float): Unit = ???
}

