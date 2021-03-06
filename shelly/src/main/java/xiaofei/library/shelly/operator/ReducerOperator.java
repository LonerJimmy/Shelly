/**
 *
 * Copyright 2016 Xiaofei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package xiaofei.library.shelly.operator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import xiaofei.library.shelly.function.Function1;

/**
 * Created by Xiaofei on 16/6/23.
 */
public class ReducerOperator<T, R> implements Function1<CopyOnWriteArrayList<T>, CopyOnWriteArrayList<R>> {

    private Function1<List<T>, ? extends R> reducer;

    public ReducerOperator(Function1<List<T>, ? extends R> reducer) {
        this.reducer = reducer;
    }

    @Override
    public CopyOnWriteArrayList<R> call(CopyOnWriteArrayList<T> input) {
        CopyOnWriteArrayList<R> result = new CopyOnWriteArrayList<R>();
        result.add(reducer.call(input));
        return result;
    }
}
