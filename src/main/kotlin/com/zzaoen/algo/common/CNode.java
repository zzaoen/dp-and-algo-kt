package com.zzaoen.algo.common;

import java.util.List;

/**
 * @author Bruce Zhao
 * @date 2021/2/20 11:02 CNode means complex node
 */
public class CNode {
  public int val;
  public List<CNode> children;

  public CNode() {}

  public CNode(int _val) {
    val = _val;
  }

  public CNode(int _val, List<CNode> _children) {
    val = _val;
    children = _children;
  }
}
