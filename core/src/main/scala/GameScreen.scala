package com.angry.micro.raptor.scalaxy

import com.badlogic.gdx.{Gdx, Screen}
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera, Texture}
import com.badlogic.gdx.math.{Rectangle, Vector2}
import com.badlogic.gdx.physics.box2d._

/**
  * Created by amram on 5/14/2018.
  */
class GameScreen(scalaxy: Scalaxy) extends Screen {
    private val img: Texture = new Texture("badlogic.jpg")

    private val world: World = new World(new Vector2(0,-10f), true)
    private var dynamicBody = this.createObject()
    private var staticBody = this.createFloor()
    private var kinematicBody = this.createMovingObject()

    private val debugRenderer: Box2DDebugRenderer = new Box2DDebugRenderer(true,true,true,true,true,true)
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
        Gdx.gl.glClearColor(0f, 0f, 0f, 1)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        scalaxy.batch.setProjectionMatrix(this.camera.combined)
        scalaxy.batch.begin()
//        scalaxy.batch.draw(this.img, 0, 20)
        debugRenderer.render(this.world, this.camera.combined)
        this.world.step(delta, 3, 3)
        this.camera.update()

        scalaxy.batch.end()
    }

    private def createObject(): Body = {
        val bodyDef: BodyDef = new BodyDef()
        bodyDef.`type` = BodyDef.BodyType.DynamicBody
        bodyDef.position.set(400,400)

        val dynamicBody = this.world.createBody(bodyDef)

        val shape: PolygonShape = new PolygonShape()
        shape.setAsBox(1,1)

        val fixtureDef: FixtureDef = new FixtureDef()
        fixtureDef.shape = shape
        fixtureDef.density = 1f

        dynamicBody.createFixture(fixtureDef)

        shape.dispose()

        dynamicBody
    }

    private def createFloor(): Body = {
        val bodyDef: BodyDef = new BodyDef()
        bodyDef.`type` = BodyDef.BodyType.StaticBody
        bodyDef.position.set(100, 100)

        val staticBody = this.world.createBody(bodyDef)

        val shape: PolygonShape = new PolygonShape()
        shape.setAsBox(50, 1)

        val fixtureDef: FixtureDef = new FixtureDef()
        fixtureDef.shape = shape
        fixtureDef.density = 0f

        staticBody.createFixture(fixtureDef)

        shape.dispose()

        staticBody
    }

    private def createMovingObject(): Body = {
        val bodyDef: BodyDef = new BodyDef()
        bodyDef.`type` = BodyDef.BodyType.KinematicBody
        bodyDef.position.set(100, 120)

        val kinematicBody = this.world.createBody(bodyDef)

        val shape: PolygonShape = new PolygonShape()
        shape.setAsBox(1,1)

        val fixtureDef: FixtureDef = new FixtureDef()
        fixtureDef.shape = shape
        fixtureDef.density = 1f

        kinematicBody.createFixture(fixtureDef)
        kinematicBody.setLinearVelocity(0, 0.75f)

        shape.dispose()

        kinematicBody
    }
}

