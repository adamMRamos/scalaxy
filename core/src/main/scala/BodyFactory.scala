package com.angry.micro.raptor.scalaxy

import com.badlogic.gdx.physics.box2d.{FixtureDef, Shape, World}

/**
  * Created by amram on 5/16/2018.
  */
object BodyFactory {
    val STEEL = 0
    val WOOD = 1
    val RUBBER = 2
    val STONE = 3

    private def setFixtureDefValues(fixtureDef: FixtureDef,
                                    density: Float, friction: Float, restitution: Float): FixtureDef = {
        fixtureDef.density = density
        fixtureDef.friction = friction
        fixtureDef.restitution = restitution
        fixtureDef
    }

    private def matchDefinition(material: Int, fixtureDef: FixtureDef): FixtureDef = material match {
        case this.STEEL => this.setFixtureDefValues(fixtureDef, 1f, 0.3f, 0.1f)
        case this.WOOD => this.setFixtureDefValues(fixtureDef, 0.5f, 0.7f, 0.3f)
        case this.RUBBER => this.setFixtureDefValues(fixtureDef, 1f, 0f, 1f)
        case this.STONE => this.setFixtureDefValues(fixtureDef, 1f, 0.9f, 0.01f)
        case _ => this.setFixtureDefValues(fixtureDef, 7f, 0.5f, 0.3f)
    }

    def makeFixtureDefinition(material: Int, shape: Shape): FixtureDef = {
        val fixtureDef = new FixtureDef()
        fixtureDef.shape = shape
        this.matchDefinition(material, fixtureDef)
    }
}
