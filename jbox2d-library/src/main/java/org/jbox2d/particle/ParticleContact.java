package org.jbox2d.particle;

import org.jbox2d.common.Vec2;

public class ParticleContact {
  /**
   * Indices of the respective particles making contact.
   * 接触各个粒子的指数
   * */
  public int indexA, indexB;
  /**
   * The logical sum of the particle behaviors that have been set.
   * 已设置粒子的行为的组合
   * */
  public int flags;

  /** Weight of the contact. A value between 0.0f and 1.0f.
   * 接触点的质量
   * */
  public float weight;
  /** he normalized direction from A to B.T
   * 从a到b进行归一化
   * */
  public final Vec2 normal = new Vec2();
}
