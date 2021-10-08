package org.jbox2d.particle;

public class ParticleGroupType {
  /**
   * 抵抗渗透
   * resists penetration
   *  */
  public static final int b2_solidParticleGroup = 1 << 0;
  /**
   * keeps its shape
   * 保持形状
   * */
  public static final int b2_rigidParticleGroup = 1 << 1;
}
