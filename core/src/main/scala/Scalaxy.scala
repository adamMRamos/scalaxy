package com.angry.micro.raptor.scalaxy

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer

class Scalaxy extends Game {
    private[scalaxy] var batch: SpriteBatch = null
    private[scalaxy] var img: Texture = null
    private[scalaxy] var world: World = null
    private[scalaxy] var camera: OrthographicCamera = null
    private[scalaxy] var debugRenderer: Box2DDebugRenderer = null

    override def create() {
        this.batch = new SpriteBatch
        this.img = new Texture("badlogic.jpg")
        this.camera = new OrthographicCamera(32, 24)
        this.debugRenderer = new Box2DDebugRenderer(true, true, true, true, true, true)
        this.world = new World(new Vector2(0,-10f), true)
    }

    override def render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        this.debugRenderer.render(this.world, this.camera.combined)
    }
}