package org.adt.core.adt.tasks;

import org.adt.core.adt.definition.IQueue;
import org.adt.core.adt.implementation.normal.Queue;

public class Task01 {

    /**
     * Desarrollar un TDA e implementacion que represente una Pila con Prioridad. Debe ser analogo a la ya
     * existente Cola con Prioridad. Calcular la complejidad computacional de cada metodo.
     */

    /**
     * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
     */
    public interface IPriorityStack {

        /**
         * Postcondicion: Apila (coloca en el fondo de la pila) un valor, respecto a su prioridad.
         *
         * @param a        valor a apilar.
         * @param priority prioridad del valor a agregar.
         */
        void add(int a, int priority);

        /**
         * Precondicion: La pila no esta vacia.
         * Postcondicion: Desapila (quita el tope de la pila).
         */
        void remove();

        /**
         * @return <code>true</code> si la pila esta vacia, <code>false</code> en otro caso.
         */
        boolean isEmpty();

        /**
         * @return Devuelve el tope.
         */
        int getTop();

        /**
         * @return Devuelve la prioridad del tope.
         */
        int getPriority();
    }

    public class PriorityStack implements IPriorityStack {

        private static final int LENGTH = 10000;

        private final int[] array;
        private final int[] priorities;
        private int count;

        public PriorityStack() {
            this.array = new int[LENGTH];
            this.priorities = new int[LENGTH];
            this.count = 0;
        }

        @Override
        public void add(int a, int priority) {
            int index = findIndex(priority);

            for (int i = this.count; i > index; i--) {
                this.array[i] = this.array[i - 1];
                this.priorities[i] = this.priorities[i - 1];
            }

            this.array[index] = a;
            this.priorities[index] = priority;

            this.count++;
        }

        // Modifico esto respecto a Cola con Prioridad para admitir prioridades repetidas
        private int findIndex(int priority) {
            for(int i = 0; i < this.priorities.length; i++) {
                if(priority < this.array[i]) {
                    return i;
                }
            }
            return this.count;
        }

        @Override
        public void remove() {
            if (count == 0) {
                System.out.println("Error, no se puede desapilar una pila vacia");
                return;
            }
            for (int i = 0; i < this.array.length - 1; i++) {
                this.array[i] = this.array[i + 1];
                this.priorities[i] = this.priorities[i + 1];
            }
            this.count--;
        }

        @Override
        public boolean isEmpty() {
            return this.count == 0;
        }

        @Override
        public int getTop() {
            if (count == 0) {
                System.out.println("Error, no se puede obtener el tope de una pila vacia");
                return -1;
            }
            return this.array[0];
        }

        @Override
        public int getPriority() {
            if (count == 0) {
                System.out.println("Error, no se puede obtener la prioridad del tope de una pila vacia");
                return -1;
            }
            return this.priorities[0];
        }
    }

    public static void add15(IQueue queue) {
        IQueue aux = new Queue();
        int count = 0;
        while(!queue.isEmpty()) {
            aux.add(queue.getFirst());
            queue.remove();
            count++;
        }

        int index = count / 2; // Dividir enteros es equivalente a redondear hacia abajo

        count = 0;
        while(!aux.isEmpty()) {
            if(count == index) {
                queue.add(15);
            }
            queue.add(aux.getFirst());
            aux.remove();
        }
    }

}
