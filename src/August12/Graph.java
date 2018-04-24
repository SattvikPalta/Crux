package August12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

import July31.GenericHeap;

public class Graph {
	private class Vertex {
		private HashMap<String, Integer> neighbours = new HashMap<>();
	}

	private HashMap<String, Vertex> vertices = new HashMap<>();

	public int numVertices() {
		return vertices.size();
	}

	public boolean containsVertex(String vName) {
		return vertices.containsKey(vName);
	}

	public void addVertex(String vName) {
		if (this.vertices.containsKey(vName))
			return;

		Vertex vtx = new Vertex();
		vertices.put(vName, vtx);
	}

	public int numEdges() {
		int rv = 0;
		ArrayList<String> vces = new ArrayList<>(vertices.keySet());
		for (String nbr : vces) {
			Vertex vtx = vertices.get(nbr);
			rv += vtx.neighbours.size();
		}

		return rv / 2;
	}

	// hasNeighbours
	public boolean containsEdge(String v1Name, String v2Name) {
		Vertex vtx1 = this.vertices.get(v1Name);
		Vertex vtx2 = this.vertices.get(v2Name);

		if (vtx1 == null || vtx2 == null || vtx1.neighbours.containsKey(v2Name) == false)
			return false;

		return true;
	}

	public void addEdge(String v1Name, String v2Name, int weight) {
		Vertex vtx1 = this.vertices.get(v1Name);
		Vertex vtx2 = this.vertices.get(v2Name);

		if (vtx1 == null || vtx2 == null)
			return;

		vtx1.neighbours.put(v2Name, weight);
		vtx2.neighbours.put(v1Name, weight);
	}

	public void removeEdge(String v1Name, String v2Name) {
		Vertex vtx1 = this.vertices.get(v1Name);
		Vertex vtx2 = this.vertices.get(v2Name);

		if (vtx1 == null || vtx2 == null)
			return;

		vtx1.neighbours.remove(v2Name);
		vtx2.neighbours.remove(v1Name);
	}

	public void removeVertex(String vName) {
		Vertex v2remove = vertices.get(vName);

		ArrayList<String> nbrNames = new ArrayList<>(v2remove.neighbours.keySet());

		for (String nbrName : nbrNames) {
			Vertex nbrVtx = this.vertices.get(nbrName);
			nbrVtx.neighbours.remove(vName);
		}

		vertices.remove(vName);
	}

	public void display() {
		ArrayList<String> vNames = new ArrayList<>(vertices.keySet());

		for (String vName : vNames) {
			String str = vName + " -> ";

			Vertex vtx = vertices.get(vName);
			ArrayList<String> nbrNames = new ArrayList<>(vtx.neighbours.keySet());

			for (String nbrName : nbrNames) {
				str += nbrName + "[" + vtx.neighbours.get(nbrName) + "], ";
			}

			System.out.println(str + ".");
		}
	}

	public boolean hasPath(String v1Name, String v2Name) {
		HashMap<String, Boolean> processed = new HashMap<>();
		return hasPathHelper(v1Name, v2Name, processed);
	}

	private boolean hasPathHelper(String v1Name, String v2Name, HashMap<String, Boolean> processed) {
		if (processed.containsKey(v1Name) == true)
			return false;

		processed.put(v1Name, true);

		if (this.containsEdge(v1Name, v2Name) == true)
			return true;

		Vertex vtx = vertices.get(v1Name);
		ArrayList<String> nbrNames = new ArrayList<>(vtx.neighbours.keySet());

		for (String nbrName : nbrNames) {
			if (hasPathHelper(nbrName, v2Name, processed))
				return true;
		}

		return false;
	}

	private class Pair {
		String vName;
		String psf;
		Vertex vtx;

		String color;

		Pair(String vName, String psf, Vertex vtx) {
			this.vName = vName;
			this.psf = psf;
			this.vtx = vtx;
		}
	}

	public boolean BFS(String v1Name, String v2Name) {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		Pair rp = new Pair(v1Name, v1Name, vertices.get(v1Name));
		stack.addLast(rp);

		while (stack.size() != 0) {
			// 1. remove
			rp = stack.removeFirst();

			// 2. check neighbours, if processed
			if (processed.containsKey(rp.vName))
				continue;

			processed.put(rp.vName, true);

			// 3. check
			System.out.println(rp.vName + " via " + rp.psf);
			if (this.containsEdge(rp.vName, v2Name) == true)
				return true;

			// 4. add the unprocessed neighbours back
			ArrayList<String> nbrNames = new ArrayList<>(rp.vtx.neighbours.keySet());
			for (String nbrName : nbrNames) {
				if (!processed.containsKey(nbrName)) {
					Pair np = new Pair(nbrName, rp.psf + nbrName, vertices.get(nbrName));
					stack.add(np);
				}
			}
		}

		return false;
	}

	public boolean DFS(String v1Name, String v2Name) {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		Pair rp = new Pair(v1Name, v1Name, vertices.get(v1Name));
		stack.addFirst(rp);

		while (stack.size() != 0) {
			// 1. remove
			rp = stack.removeFirst();

			// 2. check neighbours, if processed
			if (processed.containsKey(rp.vName))
				continue;

			processed.put(rp.vName, true);

			// 3. check
			System.out.println(rp.vName + " via " + rp.psf);
			if (this.containsEdge(rp.vName, v2Name) == true)
				return true;

			// 4. add the unprocessed neighbours back
			ArrayList<String> nbrNames = new ArrayList<>(rp.vtx.neighbours.keySet());
			for (String nbrName : nbrNames) {
				if (!processed.containsKey(nbrName)) {
					Pair np = new Pair(nbrName, rp.psf + nbrName, vertices.get(nbrName));
					stack.addFirst(np);
				}
			}
		}

		return false;
	}

	public void BFT() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> vNames = new ArrayList<>(vertices.keySet());
		for (String vName : vNames) {
			if (processed.containsKey(vName))
				continue;

			Pair rp = new Pair(vName, vName, vertices.get(vName));
			stack.addLast(rp);
			while (stack.size() != 0) {
				// 1. remove
				rp = stack.removeFirst();

				// 2. check neighbours, if processed
				if (processed.containsKey(rp.vName))
					continue;

				processed.put(rp.vName, true);

				// 3. check
				System.out.println(rp.vName + " via " + rp.psf);

				// 4. add the unprocessed neighbours back
				ArrayList<String> nbrNames = new ArrayList<>(rp.vtx.neighbours.keySet());
				for (String nbrName : nbrNames) {
					if (!processed.containsKey(nbrName)) {
						Pair np = new Pair(nbrName, rp.psf + nbrName, vertices.get(nbrName));
						stack.add(np);
					}
				}
			}
		}
	}

	public void DFT() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> vNames = new ArrayList<>(vertices.keySet());
		for (String vName : vNames) {
			if (processed.containsKey(vName))
				continue;

			Pair rp = new Pair(vName, vName, vertices.get(vName));
			stack.addFirst(rp);
			while (stack.size() != 0) {
				// 1. remove
				rp = stack.removeFirst();

				// 2. check neighbours, if processed
				if (processed.containsKey(rp.vName))
					continue;

				processed.put(rp.vName, true);

				// 3. check
				System.out.println(rp.vName + " via " + rp.psf);

				// 4. add the unprocessed neighbours back
				ArrayList<String> nbrNames = new ArrayList<>(rp.vtx.neighbours.keySet());
				for (String nbrName : nbrNames) {
					if (!processed.containsKey(nbrName)) {
						Pair np = new Pair(nbrName, rp.psf + nbrName, vertices.get(nbrName));
						stack.addFirst(np);
					}
				}
			}
		}
	}

	public boolean isConnected() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		int counter = 0;

		ArrayList<String> vNames = new ArrayList<>(vertices.keySet());
		for (String vName : vNames) {
			if (processed.containsKey(vName))
				continue;

			counter++;
			Pair rp = new Pair(vName, vName, vertices.get(vName));
			stack.addLast(rp);
			while (stack.size() != 0) {
				// 1. remove
				rp = stack.removeFirst();

				// 2. check neighbours, if processed
				if (processed.containsKey(rp.vName))
					continue;

				processed.put(rp.vName, true);

				// 3. check
				System.out.println(rp.vName + " via " + rp.psf);

				// 4. add the unprocessed neighbours back
				ArrayList<String> nbrNames = new ArrayList<>(rp.vtx.neighbours.keySet());
				for (String nbrName : nbrNames) {
					if (!processed.containsKey(nbrName)) {
						Pair np = new Pair(nbrName, rp.psf + nbrName, vertices.get(nbrName));
						stack.add(np);
					}
				}
			}
		}

		return counter == 1;
	}

	public boolean isCyclic() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> vNames = new ArrayList<>(vertices.keySet());
		for (String vName : vNames) {
			if (processed.containsKey(vName))
				continue;

			Pair rp = new Pair(vName, vName, vertices.get(vName));
			stack.addLast(rp);
			while (stack.size() != 0) {
				// 1. remove
				rp = stack.removeFirst();

				// 2. check neighbours, if processed
				if (processed.containsKey(rp.vName)) {
					System.out.println(rp.vName + " via " + rp.psf);
					return true;
				}

				processed.put(rp.vName, true);

				// 3. check
				System.out.println(rp.vName + " via " + rp.psf);

				// 4. add the unprocessed neighbours back
				ArrayList<String> nbrNames = new ArrayList<>(rp.vtx.neighbours.keySet());
				for (String nbrName : nbrNames) {
					if (!processed.containsKey(nbrName)) {
						Pair np = new Pair(nbrName, rp.psf + nbrName, vertices.get(nbrName));
						stack.add(np);
					}
				}
			}
		}

		return false;
	}

	public boolean isTree() {
		return this.isConnected() && !this.isCyclic();
	}

	private static class DijkstraPair {
		String vName;
		String psf;
		int csf;

		private static final DijkstraPairComparator ctor = new DijkstraPairComparator();

		public DijkstraPair(String vName, String psf, int csf) {
			this.vName = vName;
			this.psf = psf;
			this.csf = csf;
		}

		private static class DijkstraPairComparator implements Comparator<DijkstraPair> {
			@Override
			public int compare(DijkstraPair o1, DijkstraPair o2) {
				// TODO Auto-generated method stub
				return o2.csf - o1.csf;
			}
		}

		@Override
		public String toString() {
			return this.psf + "@" + this.csf;
		}
	}

	public HashMap<String, DijkstraPair> Dijkstra(String src) {
		HashMap<String, DijkstraPair> map = new HashMap<>();
		GenericHeap<DijkstraPair> heap = new GenericHeap<>(DijkstraPair.ctor);

		ArrayList<String> vNames = new ArrayList<>(vertices.keySet());
		for (String vName : vNames) {
			DijkstraPair pair = new DijkstraPair(vName, "", Integer.MAX_VALUE);
			if (src.equals(vName)) {
				pair.psf = vName;
				pair.csf = 0;
			}

			heap.add(pair);
			map.put(vName, pair);
		}

		while (heap.size() != 0) {
			DijkstraPair rp = heap.removeHP();
			ArrayList<String> nbrNames = new ArrayList<>(vertices.get(rp.vName).neighbours.keySet());

			for (String nbrName : nbrNames) {
				int newCost = rp.csf + vertices.get(rp.vName).neighbours.get(nbrName);
				int oldCost = map.get(nbrName).csf;

				if (newCost < oldCost) {
					DijkstraPair np = map.get(nbrName);
					np.csf = newCost;
					np.psf = rp.psf + nbrName;
					heap.updatePriority(np);
				}
			}
		}

		return map;
	}

	private static class primsPair {
		String vName;
		String acqVtxName;
		int csf;

		private static final primsPairComparator ctor = new primsPairComparator();

		public primsPair(String vName, String psf, int csf) {
			this.vName = vName;
			this.acqVtxName = acqVtxName;
			this.csf = csf;
		}

		private static class primsPairComparator implements Comparator<primsPair> {
			@Override
			public int compare(primsPair o1, primsPair o2) {
				// TODO Auto-generated method stub
				return o2.csf - o1.csf;
			}
		}
	}

	public Graph primsMST(String src) {
		Graph mst = new Graph();

		HashMap<String, primsPair> map = new HashMap<>();
		GenericHeap<primsPair> heap = new GenericHeap<>(primsPair.ctor);

		ArrayList<String> vNames = new ArrayList<>(vertices.keySet());
		for (String vName : vNames) {
			primsPair pair = new primsPair(vName, null, Integer.MAX_VALUE);
			heap.add(pair);
			map.put(vName, pair);
		}

		while (heap.size() != 0) {
			primsPair rp = heap.removeHP();
			if (rp.acqVtxName == null) {
				mst.addVertex(rp.vName);
			} else {
				mst.addVertex(rp.vName);
				mst.addEdge(rp.vName, rp.acqVtxName, rp.csf);
			}

			ArrayList<String> nbrNames = new ArrayList<>(vertices.get(rp.vName).neighbours.keySet());

			for (String nbrName : nbrNames) {
				if (mst.containsVertex(nbrName))
					continue;

				int newCost = vertices.get(rp.vName).neighbours.get(nbrName);
				int oldCost = map.get(nbrName).csf;

				if (newCost < oldCost) {
					primsPair np = map.get(nbrName);
					np.csf = newCost;
					np.acqVtxName = rp.vName;
					heap.updatePriority(np);
				}
			}
		}

		return mst;
	}

	public boolean isBipartite() {
		HashMap<String, String> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> vNames = new ArrayList<>(vertices.keySet());
		for (String vName : vNames) {
			if (processed.containsKey(vName))
				continue;

			Pair rp = new Pair(vName, vName, vertices.get(vName));
			rp.color = "red";
			stack.addLast(rp);
			while (stack.size() != 0) {
				// 1. remove
				rp = stack.removeFirst();
				String oColor = processed.get(rp.vName);
				String nColor = rp.color;

				// 2. check neighbours, if processed
				if (processed.containsKey(rp.vName)) {
					if (!oColor.equals(nColor))
						return false;

					continue;
				}

				processed.put(rp.vName, rp.color);

				// 3. add the unprocessed neighbours back
				ArrayList<String> nbrNames = new ArrayList<>(rp.vtx.neighbours.keySet());
				for (String nbrName : nbrNames) {
					if (!processed.containsKey(nbrName)) {
						Pair np = new Pair(nbrName, rp.psf + nbrName, vertices.get(nbrName));

						if (rp.color.equals("red"))
							np.color = "green";
						else
							np.color = "red";

						stack.add(np);
					}
				}
			}
		}
		
		return true;
	}
}
