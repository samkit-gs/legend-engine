// Copyright 2022 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.persistence.components.scenarios;

import org.finos.legend.engine.persistence.components.common.Datasets;
import org.finos.legend.engine.persistence.components.ingestmode.IngestMode;
import org.finos.legend.engine.persistence.components.logicalplan.datasets.Dataset;

import java.util.Optional;

public class TestScenario
{
    private Dataset mainTable;
    private Dataset stagingTable;
    private Optional<Dataset> deletePartitionTable;
    private IngestMode ingestMode;
    private Datasets datasets;

    public TestScenario(Dataset mainTable, Dataset stagingTable, IngestMode ingestMode)
    {
        this.mainTable = mainTable;
        this.stagingTable = stagingTable;
        this.deletePartitionTable = Optional.empty();
        this.ingestMode = ingestMode;
        this.datasets = Datasets.of(mainTable, stagingTable);
    }

    public TestScenario(Dataset mainTable, Dataset stagingTable, Dataset deletePartitionTable, IngestMode ingestMode)
    {
        this.mainTable = mainTable;
        this.stagingTable = stagingTable;
        this.deletePartitionTable = Optional.of(deletePartitionTable);
        this.ingestMode = ingestMode;
        this.datasets = Datasets.of(mainTable, stagingTable).withDeletePartitionDataset(deletePartitionTable);
    }

    public TestScenario(IngestMode ingestMode)
    {
        this.ingestMode = ingestMode;
    }

    public Dataset getMainTable()
    {
        return mainTable;
    }

    public Dataset getStagingTable()
    {
        return stagingTable;
    }

    public Optional<Dataset> getDeletePartitionTable()
    {
        return deletePartitionTable;
    }

    public IngestMode getIngestMode()
    {
        return ingestMode;
    }

    public Datasets getDatasets()
    {
        return datasets;
    }

    public void setDatasets(Datasets datasets)
    {
        this.datasets = datasets;
    }

    public void setMainTable(Dataset dataset)
    {
        this.mainTable = dataset;
    }
}
