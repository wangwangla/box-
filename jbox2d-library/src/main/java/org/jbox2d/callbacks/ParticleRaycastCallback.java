package org.jbox2d.callbacks;

import org.jbox2d.common.Vec2;

public interface ParticleRaycastCallback {
  /**
   * Called for each particle found in the query. See
   * {@link RayCastCallback#reportFixture(org.jbox2d.dynamics.Fixture, Vec2, Vec2, float)} for
   * argument info.
   * 
   * @param index
   * @param point
   * @param normal
   * @param fraction
   * @return
   *
   * 查到每个粒子的时候调用
   */
  float reportParticle(int index, Vec2 point, Vec2 normal, float fraction);

}
