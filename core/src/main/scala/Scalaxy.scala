package com.angry.micro.raptor.scalaxy

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.graphics.GL20

class Scalaxy extends Game {
    private[scalaxy] var batch: SpriteBatch = null
    private[scalaxy] var img: Texture = null

    override def create() {
        this.batch = new SpriteBatch
        this.img = new Texture("badlogic.jpg")
    }

    override def render() {
        Gdx.gl.glClearColor(1,0,0,1)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        this.batch.begin();
        this.batch.draw(img, 0, 0);
        this.batch.end();
    }
}