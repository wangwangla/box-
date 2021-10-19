/*******************************************************************************
 * Copyright (c) 2013, Daniel Murphy
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 	* Redistributions of source code must retain the above copyright notice,
 * 	  this list of conditions and the following disclaimer.
 * 	* Redistributions in binary form must reproduce the above copyright notice,
 * 	  this list of conditions and the following disclaimer in the documentation
 * 	  and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package org.jbox2d.callbacks;

import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.contacts.Contact;

// updated to rev 100
/**
 * Implement this class to get contact information. You can use these results for
 * things like sounds and game logic. You can also get contact results by
 * traversing the contact lists after the time step. However, you might miss
 * some contacts because continuous physics leads to sub-stepping.
 * Additionally you may receive multiple callbacks for the same contact in a
 * single time step.
 * You should strive to make your callbacks efficient because there may be
 * many callbacks per time step.
 * @warning You cannot create/destroy Box2D entities inside these callbacks.
 * @author Daniel Murphy
 *
 * 实现此类以获取联系信息。 您可以将这些结果用于声音和游戏逻辑等内容。
 * 您还可以通过在时间步之后遍历联系人列表来获取联系人结果。
 * 但是，您可能会错过一些接触，因为连续物理会导致子步进。
 * 此外，您可能会在一个时间步内收到同一联系人的多个回调。
 * 您应该努力使您的回调高效，因为每个时间步长可能有许多回调
 *
 */
public interface ContactListener {

	/**
	 * Called when two fixtures begin to touch.
	 * @param contact
	 *
	 * 接触的 时候调用
	 */
	public void beginContact(Contact contact);
	
	/**
	 * Called when two fixtures cease to touch.
	 * @param contact
	 */
	public void endContact(Contact contact);
	
	/**
	 * This is called after a contact is updated. This allows you to inspect a
	 * contact before it goes to the solver. If you are careful, you can modify the
	 * contact manifold (e.g. disable contact).
	 * A copy of the old manifold is provided so that you can detect changes.
	 * Note: this is called only for awake bodies.
	 * Note: this is called even when the number of contact points is zero.
	 * Note: this is not called for sensors.
	 * Note: if you set the number of contact points to zero, you will not
	 * get an EndContact callback. However, you may get a BeginContact callback
	 * the next step.
	 * Note: the oldManifold parameter is pooled, so it will be the same object for every callback
	 * for each thread.
	 * @param contact
	 * @param oldManifold
	 *
	 * 这在联系人更新后调用。 这允许您在接触求解器之前检查接触。
	 * 如果您小心，您可以修改接触歧管（例如禁用接触）。 提供了旧歧管的副本，
	 * 以便您可以检测更改。 注意：这仅适用于清醒的身体。 注意：即使接触点数为零，也会调用此方法。
	 * 注意：这不是传感器的要求。 注意：如果您将接触点的数量设置为零，您将不会收到 EndContact 回调。
	 * 但是，您可能会在下一步收到 BeginContact 回调。 注意：oldManifold 参数是池化的，
	 * 因此对于每个线程的每个回调，它都是相同的对象。z
	 */
	public void preSolve(Contact contact, Manifold oldManifold);
	
	/**
	 * This lets you inspect a contact after the solver is finished. This is useful
	 * for inspecting impulses.
	 * Note: the contact manifold does not include time of impact impulses, which can be
	 * arbitrarily large if the sub-step is small. Hence the impulse is provided explicitly
	 * in a separate data structure.
	 * Note: this is only called for contacts that are touching, solid, and awake.
	 * @param contact
	 * @param impulse this is usually a pooled variable, so it will be modified after
	 * this call
	 *
	 *  这使您可以在求解器完成后检查接触。 这对于检查脉冲很有用。
	 *   注意：接触流形不包括冲击脉冲的时间，如果子步小，可以任意大。
	 *   因此，在单独的数据结构中明确提供了脉冲。 注意：这仅适用于接触、固定和清醒的接触
	 */
	public void postSolve(Contact contact, ContactImpulse impulse);
}
